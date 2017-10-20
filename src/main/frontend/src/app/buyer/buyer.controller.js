(function () {
  angular
    .module('frontend')
    .controller('BuyerController', BuyerController)

  function BuyerController($scope, $http,$interval, $location,ngDialog,UtilsFunctionsFactory) {
    var vm = this;
    vm.UtilsFunctionsFactory = UtilsFunctionsFactory;
    $scope.firstName = "";
    $scope.middleName = "";
    $scope.lastName = "";
    $scope.email = "";
    $scope.phone = "";
    $scope.birthDate = "";
    $scope.livingAddress  ="";
    $scope.showAddDiv = false;

    $scope.getAllBuyers = function () {
     // var promise = $http.get($location.protocol() + '://' + $location.host() + ':'+ $location.port() + "/crudGoods/data/buyers.json");
       var promise = $http.get("../../data/buyers.json");
      promise.then(fulfilled, rejected)
    }

    function fulfilled(response){
      console.log(response);
      $scope.buyres = response.data;
      var discountMas = [];
      for(var i = 0;i<$scope.buyres.length;i++){
        var discounts = $scope.buyres[i].discounts;
        console.log(discounts);
        for(var j =0;j<discounts.length;j++){
          var actualFromDate = UtilsFunctionsFactory.toDate(discounts[j].actualFrom);
          var actualToDate = UtilsFunctionsFactory.toDate(discounts[j].actualTo);
          discounts[j].actualFrom = actualFromDate;
          discounts[j].actualTo = actualToDate;
          discountMas.unshift(discounts[j])
        }
      }
      $scope.discountsMas=discountMas;
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

    $scope.showHide1 = function () {
      this.showAddDiv = !this.showAddDiv;
    }
  }

})();
// gttp data - тело запроса bodyParam
