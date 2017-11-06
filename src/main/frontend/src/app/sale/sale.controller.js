(function () {

  angular
    .module('frontend')
    .controller('SaleController', SaleController);

  /** @ngInject */
  function SaleController($scope, $http,ngDialog,UtilsFunctionsFactory,allSells) {
    var vm = this;
    for (var i = 0;i<allSells.data.length;i++){
      var formattedOrderDate = UtilsFunctionsFactory.toDate(allSells.data[i].orderDate);
      var formattedDeliveryDate = UtilsFunctionsFactory.toDate(allSells.data[i].deliveryDate);
      allSells.data[i].orderDate = formattedOrderDate;
      allSells.data[i].deliveryDate = formattedDeliveryDate;
    }
    $scope.sales = allSells.data;

    var products = [];
    for (var i= 0;i<$scope.sales.length;i++){
      var productsS = $scope.sales[i].products;
      console.log(productsS);
      for(var j =0;j<productsS.length;j++){
        products.unshift(productsS[j]);
      }
    }
    $scope.salesProducts = products;

    var buyers = [];
    for (var i= 0;i<$scope.sales.length;i++){
      var buyer = $scope.sales[i].buyer;
      buyers.unshift(buyer);
    }
    $scope.salesBuyers = buyers;// все покупатели со всех продаж

    /*свойства для диалога*/
    $scope.saleParams = {
      orderDate:"",
      deliveryDate : "",
      amountProduct:"",
      selectedBuyer:[]
    }
    $scope.showAddDiv = false;


    $scope.addNewSale = function () {
      ngDialog.open({ template: 'app/sale/addSaleDialog.html',
        className: 'ngdialog-theme-default',
        scope: $scope
      });
    };

    $scope.dialogOkClickHandler = function () {
      debugger;
      $scope.saleParams.orderDate = UtilsFunctionsFactory.dateStringToMillis($scope.saleParams.orderDate);
      $scope.saleParams.deliveryDate = UtilsFunctionsFactory.dateStringToMillis($scope.saleParams.deliveryDate);
      $http({
        method: "POST",
        url: "http://localhost:8080/crudGoods/rest/addSale",
        params: $scope.saleParams
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

    $scope.editSale = function () {
      ngDialog.open({ template: 'app/sale/addSaleDialog.html',
        className: 'ngdialog-theme-default',
        scope: $scope
      });
    }

    $scope.deleteSale = function (scope) {
      var saleId = scope.sale.id;
      debugger;
      $http({
        method: "POST",
        url: "http://localhost:8080/crudGoods/rest/deleteSale",
        params: {
          id:saleId
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

    $scope.showAddDiv = function () {
      this.showAddDiv = !this.showAddDiv;
    }
  }
})();
