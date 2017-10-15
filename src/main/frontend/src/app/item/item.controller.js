(function () {
  angular
    .module('frontend')
    .controller('ItemController', ItemController);

  function ItemController($scope,$http,UtilsFunctionsFactory,ngDialog,$state) {
    var vm  =this;
    vm.UtilsFunctionsFactory = UtilsFunctionsFactory;
    $scope.showAddDiv = false;

    $scope.modalShown = false;

    $scope.addItem = function() {// todo not tested
      var data = {
        name:"ProductName",
        unitCoast:"5",
        unitName:"шт"
      };
      $http({
        method:"POST",
        url:"localhost:8080/crudGoods/rest/saveProduct",
        params:data
      }).then(function () {
       console.log("bla-bla")
      }, function (result) {
        console.error(result.data);
      });
      // ngDialog.open({ template: 'app/item/addItem.html',
      //   className: 'ngdialog-theme-default',
      //   scope: $scope
      // });
    }

    $scope.sendRequest = function () {
      var promise = $http.get("../../data/products.json");
      promise.then(fulfilled, rejected)
    };

    function fulfilled(response) {
      console.log(response);
      $scope.items = response.data;
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
    }

    function rejected(err) {
      console.log(err);
    }

    vm.addProductClickHandler = function () {
      alert("qwe");
    };

    $scope.editProductHandler = function () {
      alert("edit1");
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
