(function () {
  'use strict';

  angular
    .module('frontend')
    .config(routerConfig);

  /** @ngInject */
  function routerConfig($stateProvider, $urlRouterProvider) {

    // $stateProvider
    //   .state('login', {
    //     url: '/login',
    //     views: {
    //       'index': {
    //         templateUrl: 'app/login/login.html',
    //         controller: 'LoginController',
    //         controllerAs: 'loginCtrl'
    //       }
    //     },
    //     resolve: {}
    //   });

    $urlRouterProvider.otherwise(function ($injector, $location) {
      console.log($injector, $location);
      return "/";
    });
  }

})();
