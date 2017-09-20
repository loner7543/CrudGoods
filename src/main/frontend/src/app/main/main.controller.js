(function () {
  'use strict';

  angular
    .module('frontend')
    .controller('MainController', MainController);

  /** @ngInject */
  function MainController($scope) {
    $scope.param = 'GOOOD!'
  }


})();
