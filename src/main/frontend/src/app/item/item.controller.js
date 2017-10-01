(function () {
  angular
    .module('frontend').directive("modalDialog",function(){
    return {
      restrict: 'E',//применяется к элементу
      scope: {
        show: '='
      },
      replace: true, // Замените на шаблон
      transclude: true, // Пользовательский контент внутри - да
      link: function(scope, element, attrs) {
        scope.dialogStyle = {};

        if (attrs.width) {
          scope.dialogStyle.width = attrs.width;
        }

        if (attrs.height) {
          scope.dialogStyle.height = attrs.height;
        }

        scope.hideModal = function() {
          scope.show = false;
        };
      },
      template: '<div class=\'ng-modal\' ng-show=\'show\'>\n' +
      '    <div class=\'ng-modal-overlay\' ng-click=\'hideModal()\'></div>\n' +
      '        <div class=\'ng-modal-dialog\' ng-style=\'dialogStyle\'>\n' +
      '        <div class=\'ng-modal-close\' ng-click=\'hideModal()\'>X</div>\n' +
      '        <div class=\'ng-modal-dialog-content\' ng-transclude></div>\n' +
      '    </div>\n' +
      '</div>'
    };
  })
    .controller('ItemController', ItemController);

  function ItemController($scope,$http) {
    var vm  =this;
    $scope.showAddDiv = false;

    $scope.modalShown = false;
    $scope.toggleModal = function() {
      $scope.modalShown = !$scope.modalShown;
    }
    $scope.sendRequest = function () {
      var promise = $http.get("../../data/products.json");
      promise.then(fulfilled, rejected)
    };

    function fulfilled(response) {
      console.log(response);
      $scope.items = response.data;
      var discountMas = [];
      for(var i = 0;i<$scope.items.length;i++){
        var discounts = $scope.items[i].discounts;
        console.log(discounts);
        for(var j =0;j<discounts.length;j++){
          var date = new Date(discounts[j].actualFrom).toDateString();
          discounts[j].actualFrom = date;
          discountMas.push(discounts[j])
        }
      }
      $scope.discountsMas=discountMas

    }

    function rejected(err) {
      console.log(err);
    }

    vm.addProductClickHandler = function () {
      alert("qwe");
    };

    $scope.editProductHandler = function () {
      alert("edit1");
    };

    $scope.deleteProductHandler = function () {
      alert("delete")
    }

    $scope.rowClick = function () {
      alert("dedede");
    }

    $scope.showHide1 = function () {
      this.showAddDiv = !this.showAddDiv;
    }
  }
})();
