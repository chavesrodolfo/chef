'use strict';

/* Services */

var AppServices = angular.module('ChefApp.services', []);

AppServices.value('version', '0.1');

AppServices.factory('receitaService', function () {
    var receita;

    return {
        getReceita: function () {
            console.log("getReceita");
            return receita;
        },
        setReceita: function(receitaSelecionada) {
            console.log("setReceita");
            receita = receitaSelecionada;
        }
    };
});
