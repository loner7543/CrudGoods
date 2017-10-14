(function () {

  angular
    .module('frontend')
    .controller('SaleController', SaleController);

  function SaleController($scope, $http,ngDialog) {
    var vm = this;

    $scope.getAllSells = function () {
      var promise = $http.get("../../data/sells.json");
      promise.then(fulfilled, rejected)
    };

    function fulfilled(response) {
      console.log(response);
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
    }
  }
})();
