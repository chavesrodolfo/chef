'use strict';

/* Services */

var AppServices = angular.module('ChefApp.services', []);

AppServices.value('version', '0.1');

AppServices.factory('receitaService', ['$cookieStore', function ($cookieStore) {
        
        return {
        	getReceita: function () {
                console.log("receitaService>>getReceita: nome:" + $cookieStore.get('receitaSelecionada').nome + " id:" + $cookieStore.get('receitaSelecionada').id);
                return $cookieStore.get('receitaSelecionada');
            },
            setReceita: function(receitaSelecionada) {
                console.log("receitaService>>setReceita: nome:" + receitaSelecionada.nome + " id:" + receitaSelecionada.id);
                $cookieStore.put('receitaSelecionada', receitaSelecionada);
            },
            getReceitaEmEdicao: function () {
                console.log("receitaService>>getReceitaEmEdicao: " + $cookieStore.get('receitaEmEdicao'));
                return $cookieStore.get('receitaEmEdicao');
            },
            setReceitaEmEdicao: function(status) {
                console.log("receitaService>>setReceitaEmEdicao: " + status);
                $cookieStore.put('receitaEmEdicao', status);
            },

        };
}]);