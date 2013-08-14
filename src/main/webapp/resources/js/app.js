'use strict';

var ChefApp = {};

var App = angular.module('ChefApp', ['ChefApp.filters', 'ChefApp.services', 'ChefApp.directives']);

App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/home', {
        templateUrl: 'home/layout',
        controller: HomeController
    });

    $routeProvider.when('/receita', {
        templateUrl: 'receita/layout',
        controller: ReceitaController
    });

    $routeProvider.otherwise({redirectTo: '/home'});
}]);
