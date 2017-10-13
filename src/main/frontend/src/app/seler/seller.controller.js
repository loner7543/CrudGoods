(function () {
  angular
    .module('frontend')
    .controller('SellersController', SellersController);

  function SellersController($scope, $http) {
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
    }
  }
})();
