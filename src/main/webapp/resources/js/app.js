'use strict';

var ChefApp = {};

var App = angular.module('ChefApp', ['ChefApp.filters', 'ChefApp.services', 'ChefApp.directives', 'ngCookies', 'ui.bootstrap.dialog']);

App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/home', {
        templateUrl: 'home/layout',
        controller: HomeController
    });

    $routeProvider.when('/receitas/visualizareceita', {
        templateUrl: 'receitas/visualizareceita',
        controller: ReceitaController
    });

    $routeProvider.when('/receitas/cadastroreceita', {
        templateUrl: 'receitas/cadastroreceita',
        controller: ReceitaController
    });

    $routeProvider.otherwise({redirectTo: '/home'});
}]);
