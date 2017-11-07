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

    $scope.discountsMas= discountMas
    $scope.showAddDiv=false

    $scope.params = {
      name: "",
      unitCoast: "",
      unitName: ""
    };

    $scope.modalShown = false;

    $scope.addItem = function() {
      ngDialog.open({ template: 'app/item/addItem.html',
       className: 'ngdialog-theme-default',
       scope: $scope
      });
    }

    $scope.editOkHandler = function () {
      debugger;
      console.log( $scope.params);

      $scope.params.id=1;
      var data = $scope.params
      $http({
        method: "PUT",
        url: "http://localhost:8080/crudGoods/rest/updateProduct",
        data:  $scope.params,
        headers: {
          "Content-Type": "application/json"
        }
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

    /*
    * Создание нового товара
    * */
    $scope.dialogOkHandler = function () {
      console.log( $scope.params);
      var dataObj =$scope.params;
      $http({
        method: "POST",
        url: "http://localhost:8080/crudGoods/rest/saveProduct",
        params: dataObj
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

    $scope.editProductHandler = function (scope) {
      console.log(scope);
      $scope.params.name=scope.item.name;
      $scope.params.unitCoast = scope.item.unitCoast;
      $scope.params.unitName=scope.item.unitName;

      ngDialog.open({ template: 'app/item/editProduct.html',
        className: 'ngdialog-theme-default',
        scope: $scope
      });
    };

    $scope.deleteProductHandler = function (scope) {
      debugger;
      var deletedId= scope.item.id;
      console.log(deletedId);
      $http({
        method: "DELETE", // todo change method type
        url: "http://localhost:8080/crudGoods/rest/removeProduct",
        params: {
          id:deletedId
        }
      }).then(function (resp) {
          debugger;
          console.log("Success resp1", resp)
          $state.reload();
        },
        function (result) {
          debugger;
          console.error(result);
        });
    }


    $scope.showHide1 = function () {
      this.showAddDiv = !this.showAddDiv;
    }
  }
})();
