(function () {
  angular
    .module('frontend')
    .controller('BuyerController', BuyerController)

  /** @ngInject */
  function BuyerController($scope, $http, $state,$interval, $location,ngDialog,UtilsFunctionsFactory,allBuyers) {
    var vm = this;
    vm.UtilsFunctionsFactory = UtilsFunctionsFactory;
    for (var i = 0;i<allBuyers.data.length;i++){
      var formattedBirthDate = UtilsFunctionsFactory.toDate(allBuyers.data[i].birthDate);
      allBuyers.data[i].birthDate = formattedBirthDate;
    }
    $scope.buyres = allBuyers.data;
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
    $scope.firstName = "";
    $scope.middleName = "";
    $scope.lastName = "";
    $scope.email = "";
    $scope.phone = "";
    $scope.birthDate = "";
    $scope.livingAddress  ="";
    $scope.showAddDiv = false;

      // var promise = $http.get($location.protocol() + '://' + $location.host() + ':'+ $location.port() + "/crudGoods/data/buyers.json");
      //  var promise = $http.get("../../data/buyers.json");
    $scope.showBuyerDialog = function() {

      var buyer = {
        firstName: "ce",
        middleName:"ce",
        lastName:"ce",
        birthDate:12223,
        phoneNumber:"phone",
        livingAddress:"ce",
      };
      $http({
        method: "POST",
        url: "http://localhost:8080/crudGoods/rest/addBuyer",
        params: buyer
      }).then(function (resp) {
          debugger;
          console.log("Success resp", resp)
          $state.reload();
        },
        function (result) {
          debugger;
          console.error(result, result.data);
        });

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
