(function () {

  angular
    .module('frontend')
    .controller('SaleController', SaleController);

  function SaleController($scope, $http) {
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
  }
})();
