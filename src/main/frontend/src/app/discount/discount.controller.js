(function () {

  angular
    .module('frontend')
    .controller('DiscountController', DiscountController);

  function DiscountController($scope, $http,UtilsFunctionsFactory,ngDialog) {
    var vm = this;
    $scope.sendRequest = function () {
      var promise = $http.get("../../data/discounts.json");
      promise.then(fulfilled, rejected)
    };

    function fulfilled(resp) {
      console.log(resp);
      var log = [];
      angular.forEach(resp.data, function(value, key) {
        console.log(value);
        console.log(key);
        this.push(key + ': ' + value);
      }, log);
      $scope.discounts = resp.data;
    }

    function rejected(errror) {
      console.log(errror)
    }

    $scope.addDiscount = function() {
      ngDialog.open({ template: 'app/discount/addDiscount.html',
        className: 'ngdialog-theme-default',
        scope: $scope
      });
    }

    $scope.saveDiscount = function () {
      console.log("bla")
    }

  }
})();
