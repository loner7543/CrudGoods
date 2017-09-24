(function () {
  'use strict';

  angular
    .module('frontend')
    .controller('MainController', MainController);

  function MainController($scope) {
    var vm = this;
    $scope.param = 'GOOOD!'

    $scope.addProductClickHandler = function () {
      alert("qwe");
    },

    $scope.editProductHandler = function () {
      alert("edit1");
    },

    $scope.deleteProductHandler = function(){
      alert("delete")
    }
  }


})();
