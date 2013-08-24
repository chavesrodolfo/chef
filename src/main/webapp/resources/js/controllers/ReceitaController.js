'use strict';

var ReceitaController = function($scope, $http, $location, $anchorScroll, receitaService) {

    $scope.scrollTo = function(id) {
        $location.hash(id);
        console.log($location.hash());
        $anchorScroll();
    };

    $scope.receita = receitaService.getReceita();

}