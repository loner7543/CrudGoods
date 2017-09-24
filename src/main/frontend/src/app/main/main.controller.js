(function () {
  'use strict';

  angular
    .module('frontend')
    .controller('MainController', MainController);

  function MainController($scope,$http) {
    var vm = this;

    $scope.sendRequest = function () {
     var promise =  $http.get("../../data/products.json");
     promise.then(fulfilled,rejected)
    }

     function fulfilled (response) {
      console.log(response);
      $scope.items = response.data;
    }

    function rejected (err) {
      console.log(err);
    }

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
