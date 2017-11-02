(function () {
  angular
    .module('frontend')
    .controller('SellersController', SellersController);

  /** @ngInject */
  function SellersController($scope, $http,ngDialog,UtilsFunctionsFactory,allSellers) {
    var vm = this;

    for (var i = 0;i<allSellers.data.length;i++){
      var orderDate = UtilsFunctionsFactory.toDate(allSellers.data[i].sale.orderDate);// из продажи
      var deliveryDate = UtilsFunctionsFactory.toDate(allSellers.data[i].sale.deliveryDate);// из продажи
      var formattedBirthDate = UtilsFunctionsFactory.toDate(response.data[i].birthDate);
      allSellers.data[i].birthDate = formattedBirthDate;
      allSellers.data[i].sale.orderDate = orderDate;
      allSellers.data[i].sale.deliveryDate = deliveryDate;
    }

    $scope.sellers = allSellers.data;

    /*для диалога*/
    $scope.sellerFirstName = "";
    $scope.sellerMiddleName="";
    $scope.sellerLastName="";
    $scope.birthDate = "";
    $scope.sellerEmail="";
    $scope.sellerDeliveryAddress="";

    $scope.getAllSellers = function () {
      var promise = $http.get("../../data/sellers.json");
      promise.then(fulfilled, rejected);

      function fulfilled(response) {
        console.log(response);
      }

      function rejected(err) {
        console.log(err);
      }

      $scope.addNewSeller = function () {
        ngDialog.open({ template: 'app/seler/addSellerDialog.html',
          className: 'ngdialog-theme-default',
          scope: $scope
        });
      };

      $scope.editSeller = function () {
        ngDialog.open({ template: 'app/seler/addSellerDialog.html',
          className: 'ngdialog-theme-default',
          scope: $scope
        });
      };

      $scope.deleteSeller = function () {

      }
    }
  }
})();
