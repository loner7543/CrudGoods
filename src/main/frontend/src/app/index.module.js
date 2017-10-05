(function () {
  'use strict';

  angular
    .module('frontend', ['ngAnimate', 'ngCookies', 'ngTouch', 'ngSanitize', 'ngMessages', 'ngAria', 'ui.router','ui.bootstrap', 'toastr', 'ngMask'])
  .factory("UtilsFunctionsFactory",UtilsFunctionsFactory);
  //модуль + его зависимости + фабрика

  /** @ngInject */
  function UtilsFunctionsFactory() {
    return{
      toDate:function (value) {
        return new Date(value).toDateString()
      }
    }
  }


})();
