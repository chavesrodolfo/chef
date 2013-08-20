'use strict';

/* Services */

var AppServices = angular.module('ChefApp.services', []);

AppServices.value('version', '0.1');

AppServices.factory('receitaService', ['$cookieStore', function ($cookieStore) {
        var receita;

        return {
            getReceita: function () {
                console.log("getReceita");
                $cookieStore.get('receitaSelecionada');
                return $cookieStore.get('receitaSelecionada');
            },
            setReceita: function(receitaSelecionada) {
                console.log("setReceita");
                $cookieStore.put('receitaSelecionada', receitaSelecionada);
                receita = receitaSelecionada;
            },

        };
}]);