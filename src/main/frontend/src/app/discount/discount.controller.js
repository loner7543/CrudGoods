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

    //для добавления
    var buyerPromise =$http.post("http://localhost:8080/crudGoods/rest/getAllBuyers");
    -      buyerPromise.then(fulfilled, rejected);

    function fulfilled(resp) {
      console.log(resp.data);
      for (var i =0;i<resp.data.length;i++){
        resp.data[i].birthDate = UtilsFunctionsFactory.toDate(resp.data[i].birthDate);
      }
      $scope.buyers = resp.data;
    }

    function rejected(error) {
      debugger;
      console.log(error);
    }

    var productPromise =$http.post("http://localhost:8080/crudGoods/rest/getProducts");
    -      productPromise.then(productFulfilled, productRejected);

    function productFulfilled(resp) {
      console.log(resp.data);
      $scope.products = resp.data;
    }

    function productRejected(error) {
      debugger;
      console.log(error);
    }


    $scope.discountParams={
      actualFrom:"",
      actualTo:"",
      amountDiscount:"",
      selectedBuyer:0,
      selectedProduct:0
    };

    $scope.addDiscount = function() {
      ngDialog.open({ template: 'app/discount/addDiscount.html',
        className: 'ngdialog-theme-default',
        scope: $scope
      });
    }

    $scope.discountOkClickHandler = function () {
      debugger;
      $scope.discountParams.actualFrom=UtilsFunctionsFactory.dateStringToMillis($scope.discountParams.actualFrom);
      $scope.discountParams.actualTo=UtilsFunctionsFactory.dateStringToMillis($scope.discountParams.actualTo);
      console.log($scope.discountParams);
      $http({
        method: "POST",
        url: "http://localhost:8080/crudGoods/rest/addDiscount",
        params:  $scope.discountParams
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
