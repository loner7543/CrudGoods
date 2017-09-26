(function () {
  'use strict';

  angular
    .module('frontend')
    .config(routerConfig);

  /** @ngInject */
  function routerConfig($stateProvider, $urlRouterProvider) {

    // var buyerState={
    //   name:"buyer",
    //   url:"/buyer",
    //   template:"<h3>deffef</h3>h3>"
    // };
    // debugger;
    // $stateProvider.state(buyerState);


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

     $stateProvider
       .state('buyer', {
         url: '/buyer',
         views: {
           'index': {
             templateUrl: 'app/buyer/buyer.html',
             controller: 'BuyerController',
             controllerAs: 'buyerCtrl'
           }
         },
         resolve: {}
       });

    $urlRouterProvider.otherwise(function ($injector, $location) {
      console.log($injector, $location);
      return "/";
    });
  }

})();
