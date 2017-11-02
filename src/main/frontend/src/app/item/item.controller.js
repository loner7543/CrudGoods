(function () {
  angular
    .module('frontend')
    .controller('ItemController', ItemController);

  /** @ngInject */
  function ItemController($scope,$http,UtilsFunctionsFactory,ngDialog,$state,allProducts) {
    var vm  =this;
     $scope.items = allProducts.data;
    vm.UtilsFunctionsFactory = UtilsFunctionsFactory;
    var discountMas = [];
    for(var i = 0;i<$scope.items.length;i++){
      var discounts = $scope.items[i].discounts;
      console.log(discounts);
      for(var j =0;j<discounts.length;j++){
        var actualFromDate = UtilsFunctionsFactory.toDate(discounts[j].actualFrom);
        var actualToDate = UtilsFunctionsFactory.toDate(discounts[j].actualTo);
        discounts[j].actualFrom = actualFromDate;
        discounts[j].actualTo = actualToDate;
        discountMas.unshift(discounts[j])
      }
    }
    $scope.discountsMas=discountMas
    $scope.showAddDiv = false;
    $scope.productName = '';
    $scope.unitCoast = "";
    $scope.unitName = "";

    $scope.modalShown = false;

    $scope.addItem = function() {
      ngDialog.open({ template: 'app/item/addItem.html',
       className: 'ngdialog-theme-default',
       scope: $scope
      });
    }

    $scope.dialogOkHandler = function () {
      debugger;
      var data = {
        name: $scope.productName,
        unitCoast:"7",
        unitName:"шт"
      };
      $http({
        method: "POST",
        url: "http://localhost:8080/crudGoods/rest/saveProduct",
        params: data
      }).then(function (resp) {
          debugger;
          console.log("Success resp1", resp)
          $state.reload();
        },
        function (result) {
          debugger;
          console.error(result, result.data);
        });
    }

    $scope.dialogCancelHandler = function () {

    }

    $scope.editProductHandler = function () {
      $scope.productName = "qwe";
      ngDialog.open({ template: 'app/item/addItem.html',
        className: 'ngdialog-theme-default',
        scope: $scope
      });
    };

    $scope.deleteProductHandler = function () {
      alert("delete")
    }

    $scope.rowClick = function () {
      alert("dedede");
    }

    $scope.showHide1 = function () {
      this.showAddDiv = !this.showAddDiv;
    }
  }
})();
