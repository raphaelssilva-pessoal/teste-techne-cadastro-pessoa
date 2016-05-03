'use strict';
var app = angular.module("app", ['ngRoute']);
app.config(function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : 'view/pessoa/list.html',
            controller  : 'cadastroPessoaCtrl'
        })

        .when('/create', {
            templateUrl : 'view/pessoa/form.html',
            controller  : 'cadastroPessoaCtrl'
        })

        .when('/edit/:id', {
        	 templateUrl : 'view/pessoa/form.html',
             controller  : 'cadastroPessoaCtrl'
         });
});