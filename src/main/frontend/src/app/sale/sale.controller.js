(function () {

  angular
    .module('frontend')
    .controller('SaleController', SaleController);

  /** @ngInject */
  function SaleController($scope, $http,ngDialog,UtilsFunctionsFactory) {
    var vm = this;
    $scope.orderDate="";
    $scope.deliveryDate = "";
    $scope.amountProduct="";

    $scope.getAllSells = function () {
      var promise = $http.get("../../data/sells.json");
      promise.then(fulfilled, rejected)
    };

    function fulfilled(response) {
      console.log(response);
      for (var i = 0;i<response.data.length;i++){
        var formattedOrderDate = UtilsFunctionsFactory.toDate(response.data[i].orderDate);
        var formattedDeliveryDate = UtilsFunctionsFactory.toDate(response.data[i].deliveryDate);
        response.data[i].orderDate = formattedOrderDate;
        response.data[i].deliveryDate = formattedDeliveryDate;
      }
      $scope.sales = response.data;
    }

    function rejected(err) {
      console.log(err);
    }

    $scope.addNewSale = function () {
      ngDialog.open({ template: 'app/sale/addSaleDialog.html',
        className: 'ngdialog-theme-default',
        scope: $scope
      });
    };

    $scope.editSale = function () {
      ngDialog.open({ template: 'app/sale/addSaleDialog.html',
        className: 'ngdialog-theme-default',
        scope: $scope
      });
    }

    $scope.deleteSale = function () {

    }
  }
})();
