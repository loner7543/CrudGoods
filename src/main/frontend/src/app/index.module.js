(function () {
  'use strict';

  angular
    .module('frontend', ['ngAnimate', 'ngCookies', 'ngTouch', 'ngSanitize', 'ngMessages', 'ngAria', 'ui.router','ui.bootstrap', 'toastr', 'ngMask','ngDialog'])
  .factory("UtilsFunctionsFactory",UtilsFunctionsFactory);
  //модуль + его зависимости + фабрика
  //http://dotansimha.github.io/angularjs-dropdown-multiselect/docs/#/main
//https://www.youtube.com/watch?v=2tx1B8zXNqo
//http://stepansuvorov.com/blog/2014/09/angularjs-data-transfer/
//http://jsfiddle.net/STEVER/9a2sLdy6/

  /** @ngInject */
  function UtilsFunctionsFactory() {
    return{
      toDate:function (value) {
        // var dateValue = new Date(value);
        // var dd = dateValue.getDate();
        // var mm = dateValue.getMonth()+1; //January is 0!
        //
        // var yyyy = dateValue.getFullYear();
        // if(dd<10){
        //   dd='0'+dd;
        // }
        // if(mm<10){
        //   mm='0'+mm;
        // }
        // var formattedDate = dd+'.'+mm+'.'+yyyy;
        // return formattedDate;
        moment.locale('ru');
        return moment(value).format('L')
      },

      dateStringToMillis:function(date){
          var time = new Date(date).getTime();
          return isNaN(time) ? null : time;
      }
  }


}})();

