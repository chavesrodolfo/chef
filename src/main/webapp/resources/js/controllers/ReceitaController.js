'use strict';

var ReceitaController = function($scope, $http, $location, $anchorScroll, receitaService) {

	$scope.receita = {id:"",nome:"",resumo:"",ingredientes:"",observacoes:"",notaChef:"", tags:[]};
	
    $scope.obterReceita = function() {
    	$scope.receita = receitaService.getReceita();
    };
    
    /**
     * Caso a receita esteja em edicao esse metodo eh chamado para carregar a receita que esta em cookie e preencher o formilario
     */
    $scope.obterReceitaEmEdicao = function() {
    	/*$('#ingredientes').redactor();
    	$('#preparo').redactor();
    	$('#obs').redactor();*/
    	$scope.tags ="";
    	
    	if(receitaService.getReceitaEmEdicao()){
    		$scope.receita = receitaService.getReceita();
    		for(var i=0;i<$scope.receita.tags.length;i++){
    			console.log("ReceitaController>>obterReceitaEmEdicao>>tags recuperadas: "+ $scope.receita.tags[i].nome);
    			$scope.tags += $scope.receita.tags[i].nome+",";
    		}
    		$scope.tags = $scope.tags.substring(0, $scope.tags.length-1);
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
    		console.log("ReceitaController>>edita receita: "+$scope.receita.nome);
	        
    		$scope.parseTags();
    		$scope.parseHtml();
 	        
    		$http.put('receitas/atualiza', $scope.receita).success(function() {
	        }).error(function() {
	            alert('erro');
	        });
    	} else {
	        console.log("ReceitaController>>adiciona receita: "+$scope.receita.nome);
	       
	        $scope.parseTags();
	        $scope.parseHtml();
	        
	        console.log("ReceitaController>>$scope.tags:"+$scope.tags);
	        
	        $http.post('receitas/adiciona', $scope.receita).success(function() {
	        }).error(function() {
	            alert('erro');
	        });
    	}
    	
    	receitaService.setReceita($scope.receita);
    	receitaService.setReceitaEmEdicao(false);
    };
    
    $scope.parseTags = function() {
    	var scopeTags = $scope.tags;
        var tags = scopeTags.split(",");
        	        
        for (var i=0; i<tags.length; i++){
        	console.log("ReceitaController>>tag["+i+"]:"+tags[i]);
        	$scope.tag = {id:"",nome: tags[i]};
        	//nao insere tags repetidas
        	if(!$scope.existeTag($scope.tag.nome)){
        		$scope.receita.tags.push($scope.tag);
        	}
        }
    };
    
    $scope.existeTag = function(tag) {
    	for(var i=0; i<$scope.receita.tags.length; i++){
    		if($scope.receita.tags[i].nome==tag){
    			return true;
    		}
    	}
    	return false;
    };
    
    $scope.parseHtml = function() {
    	$scope.receita.ingredientes = $scope.receita.ingredientes.replace(/\n/g, '<br/>');
    	$scope.receita.modoPreparo = $scope.receita.modoPreparo.replace(/\n/g, '<br/>');
    	$scope.receita.observacoes = $scope.receita.observacoes.replace(/\n/g, '<br/>');
    };
    
};