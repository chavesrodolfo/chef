'use strict';

var HomeController = function($scope, $http, receitaService) {

    $scope.listarReceitasHome = function() {
        $http.get('receitas/receitas.json').success(function(receitas){
            $scope.receitasHome = receitas;
        });
    }

    $scope.carregarReceita = function(receita) {
        receitaService.setReceita(receita);
        console.log(receita.nome+":"+receita.id);
    }

    $scope.listarReceitasHome();
}