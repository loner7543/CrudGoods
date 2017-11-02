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

    $scope.amountDiscount="";

    $scope.addDiscount = function() {

      var discount = {
        actualFrom: 1122,
        actualTo:12223,
        amountDiscount:50
      };
      $http({
        method: "POST",
        url: "http://localhost:8080/crudGoods/rest/addDiscount",
        params: discount
      }).then(function (resp) {
          debugger;
          console.log("Success resp", resp)
          $state.reload();
        },
        function (result) {
          debugger;
          console.error(result, result.data);
        });

      ngDialog.open({ template: 'app/discount/addDiscount.html',
        className: 'ngdialog-theme-default',
        scope: $scope
      });
    }

    $scope.discountOkClickHandler = function () {

    }

    $scope.editDiscount = function () {
      ngDialog.open({ template: 'app/discount/addDiscount.html',
        className: 'ngdialog-theme-default',
        scope: $scope
      });
    }

    $scope.deleteDiscount = function () {

    }

  }
})();
