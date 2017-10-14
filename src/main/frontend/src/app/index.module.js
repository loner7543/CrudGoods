(function () {
  'use strict';

  angular
    .module('frontend', ['ngAnimate', 'ngCookies', 'ngTouch', 'ngSanitize', 'ngMessages', 'ngAria', 'ui.router','ui.bootstrap', 'toastr', 'ngMask','ngDialog'])
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
//http://dotansimha.github.io/angularjs-dropdown-multiselect/docs/#/main
