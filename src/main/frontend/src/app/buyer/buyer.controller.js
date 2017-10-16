(function () {
  angular
    .module('frontend')
    .controller('BuyerController', BuyerController)

  function BuyerController($scope, $http,$interval, $location,ngDialog) {
    var vm = this;
    $scope.firstName = "";
    $scope.middleName = "";
    $scope.lastName = "";
    $scope.email = "";
    $scope.phone = "";
    $scope.birthDate = "";
    $scope.livingAddress  ="";

    $scope.getAllBuyers = function () {
     // var promise = $http.get($location.protocol() + '://' + $location.host() + ':'+ $location.port() + "/crudGoods/data/buyers.json");
       var promise = $http.get("../../data/buyers.json");
      promise.then(fulfilled, rejected)
    }

    function fulfilled(response){
      console.log(response);
      $scope.buyres = response.data;
    }

    function rejected(err) {
      console.log(err);
    }
    $scope.showBuyerDialog = function() {
      ngDialog.open({ template: 'app/buyer/addBuyer.html',
        className: 'ngdialog-theme-default',
        scope: $scope
      });
    };

    $scope.editBuyer = function () {
      ngDialog.open({ template: 'app/buyer/addBuyer.html',
        className: 'ngdialog-theme-default',
        scope: $scope
      });
    };

    $scope.deleteBuyer = function () {

    };
  }

})();
