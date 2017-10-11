(function () {
  angular
    .module('frontend')
    .controller('BuyerController', BuyerController).directive('popUpDialog', function(){
    return {
      restrict: 'E',
      // scope: false,
      templateUrl: 'app/buyer/buyerDialog.html',
      controller: function( $scope ) {
        $scope.closePopUpDialog = function() {
          console.log("cancel")
          $scope.showPopUpDialog = false;
        }

        $scope.popUpDialogApprove = function() {
          console.log("yes")
          $scope.showPopUpDialog = false;
        }
      }
    }
  })

  function BuyerController($scope, $http,$interval, $location) {
    var vm = this;

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
      $scope.showPopUpDialog = true;
    }
  }

})();
