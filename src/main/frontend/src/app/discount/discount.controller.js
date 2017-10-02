(function () {

  angular
    .module('frontend')
    .controller('DiscountController', DiscountController);

  function DiscountController($scope, $http) {
    var vm = this;
    $scope.sendRequest = function () {
      var promise = $http.get("../../data/discounts.json");
      promise.then(fulfilled, rejected)
    };

    function fulfilled(resp) {
      console.log(resp);
      $scope.discounts = resp.data;
    }

    function rejected(errror) {
      console.log(errror)
    }

    $scope.addDiscount = function() {
    }

  }
})();
