'use strict';

var ChefApp = {};

var App = angular.module('ChefApp', ['app.filters', 'app.services', 'app.directives']);

App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/home', {
        templateUrl: 'home/layout',
        controller: HomeController
    });

    $routeProvider.otherwise({redirectTo: '/home'});
}]);
