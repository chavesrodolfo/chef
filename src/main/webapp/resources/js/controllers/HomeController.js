'use strict';

var HomeController = function($scope, $http, $location, $anchorScroll, receitaService) {

    $scope.scrollTo = function(id) {
        $location.hash(id);
        console.log($location.hash());
        $anchorScroll();
    };

    $scope.listarReceitasHome = function() {
        $http.get('receitas/receitas.json').success(function(receitas){
            $scope.receitasHome = receitas;
        });
    };
    
    $scope.prepararNovaReceita = function() {
    	receitaService.setReceitaEmEdicao(false);
    };

    $scope.carregarReceita = function(receita) {
        receitaService.setReceita(receita);
        console.log("HomeController>>carregarReceita nome:"+receita.nome+" id:"+receita.id);
    };

    $scope.listarReceitasHome();
};