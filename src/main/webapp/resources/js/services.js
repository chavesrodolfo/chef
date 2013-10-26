'use strict';

/* Services */

var AppServices = angular.module('ChefApp.services', []);

AppServices.value('version', '0.1');

AppServices.factory('receitaService', ['$cookieStore', function ($cookieStore) {
        
        return {
        	getReceita: function () {
                console.log("getReceita");
                return $cookieStore.get('receitaSelecionada');
            },
            setReceita: function(receitaSelecionada) {
                console.log("setReceita");
                $cookieStore.put('receitaSelecionada', receitaSelecionada);
            },
            getReceitaEmEdicao: function () {
                console.log("getReceita em edicao:" + status);
                return $cookieStore.get('receitaEmEdicao');
            },
            setReceitaEmEdicao: function(status) {
                console.log("setReceita em edicao:" + status);
                $cookieStore.put('receitaEmEdicao', status);
            },

        };
}]);