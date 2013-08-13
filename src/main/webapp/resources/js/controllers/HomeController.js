'use strict';

var HomeController = function($scope, $http) {

    $scope.listarReceitasHome = function() {
        $http.get('receitas/receitas.json').success(function(receitas){
            $scope.receitasHome = receitas;
        });
    }

    $scope.listarReceitasHome();
}