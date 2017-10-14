(function () {
  angular
    .module('frontend')
    .controller('SellersController', SellersController);

  function SellersController($scope, $http,ngDialog) {
    var vm = this;

    $scope.getAllSellers = function () {
      var promise = $http.get("../../data/sellers.json");
      promise.then(fulfilled, rejected);

      function fulfilled(response) {
        console.log(response);
        $scope.sellers = response.data;
      }

      function rejected(err) {
        console.log(err);
      }

      $scope.addNewSeller = function () {
        ngDialog.open({ template: 'app/seler/addSellerDialog.html',
          className: 'ngdialog-theme-default',
          scope: $scope
        });
      }
    }
  }
})();
