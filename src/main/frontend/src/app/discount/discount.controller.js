(function () {

  angular
    .module('frontend')
    .controller('DiscountController', DiscountController);

  /** @ngInject */
  function DiscountController($scope,$state, $http,UtilsFunctionsFactory,ngDialog,allDiscounts) {
    var vm = this;
    for (var i = 0;i<allDiscounts.data.length;i++){
      var formattedFromDate = UtilsFunctionsFactory.toDate(allDiscounts.data[i].actualFrom);
      var formattedToDate = UtilsFunctionsFactory.toDate(allDiscounts.data[i].actualTo);
      allDiscounts.data[i].actualTo = formattedToDate;
      allDiscounts.data[i].actualFrom = formattedFromDate;
    }
    $scope.discounts = allDiscounts.data;

    $scope.discountParams={
      actualFrom:"",
      actualTo:"",
      amountDiscount:""// даты - строки!
    };

    $scope.addDiscount = function() {
      ngDialog.open({ template: 'app/discount/addDiscount.html',
        className: 'ngdialog-theme-default',
        scope: $scope
      });
    }

    $scope.discountOkClickHandler = function () {
      debugger;
      var newDiscount = {
        actualFrom:UtilsFunctionsFactory.dateStringToMillis($scope.discountParams.actualFrom),
        actualTo:UtilsFunctionsFactory.dateStringToMillis($scope.discountParams.actualTo),
        amountDiscount:$scope.discountParams.amountDiscount
      }
      console.log(newDiscount);
      $http({
        method: "POST",
        url: "http://localhost:8080/crudGoods/rest/addDiscount",
        params:  newDiscount
      }).then(function (resp) {
          debugger;
          console.log("Success resp", resp)
          $state.reload();
        },
        function (result) {
          debugger;
          console.error(result, result.data);
        });
    }

    $scope.discountCancelClicHandler = function () {

    }

    $scope.editDiscount = function () {
      ngDialog.open({ template: 'app/discount/addDiscount.html',
        className: 'ngdialog-theme-default',
        scope: $scope
      });
    }

    $scope.deleteDiscount = function (scope) {
      debugger;
      var deletedId = scope.discount.id;
      $http({
        method: "DELETE",
        url: "http://localhost:8080/crudGoods/rest/deleteDiscount",
        params: {
          id:deletedId
        }
      }).then(function (resp) {
          debugger;
          console.log("Success resp1", resp)
          $state.reload();
        },
        function (result) {
          debugger;
          console.error(result);
        });
    }

  }
})();
