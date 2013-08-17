'use strict';

var ReceitaController = function($scope, $http, receitaService) {

    $scope.receita = receitaService.getReceita();

}