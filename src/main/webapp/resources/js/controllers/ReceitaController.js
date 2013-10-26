'use strict';

var ReceitaController = function($scope, $http, $location, $anchorScroll, receitaService) {

	//$scope.receita = {id:"",nome:"",resumo:"",ingredientes:"",observacoes:"",notaChef:""};
	
    $scope.obterReceita = function() {
    	$scope.receita = receitaService.getReceita();
    };
    
    /**
     * Caso a receita esteja em edicao esse metodo eh chamado para carregar a receita que esta em cookie e preencher o formilario
     */
    $scope.obterReceitaEmEdicao = function() {
    	if(receitaService.getReceitaEmEdicao()){
    		$scope.receita = receitaService.getReceita();
    	}
    };
    
    $scope.definirReceitaEmEdicao = function() {
    	receitaService.setReceitaEmEdicao(true);
    };
    
    $scope.scrollTo = function(id) {
        $location.hash(id);
        console.log($location.hash());
        $anchorScroll();
    };
    
    $scope.cadastrarReceita = function() {
    	if(receitaService.getReceitaEmEdicao()){
    		console.log("receita editada: "+$scope.receita.nome);
	        
    		$http.put('receitas/atualiza', $scope.receita).success(function() {
	        }).error(function() {
	            alert('erro');
	        });
    	} else {
	        console.log("adicionada receita: "+$scope.receita.nome);
	        
	        $http.post('receitas/adiciona', $scope.receita).success(function() {
	        }).error(function() {
	            alert('erro');
	        });
    	}
    	
    	receitaService.setReceita($scope.receita);
    	receitaService.setReceitaEmEdicao(false);
    };
    
};