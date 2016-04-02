'use strict';

/**
 * @ngdoc object
 * @name presentItApp
 * @requires $routeProvider
 * @requires presentItControllers
 * @requires ui.bootstrap
 * 
 * @description Root app, which routes and specifies the partial html and
 *              controller depending on the url requested.
 * 
 */

var presentItApp = angular.module('presentItApp', [ 'ngRoute' ]).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/', {
				templateUrl : '/partials/landing.html',
				controller : 'LandingCtrl'
			}).otherwise({
				redirectTo : '/'
			});
		} ]);

/*
 * The Controllers start from here All that is before this is the app properties
 * and after this is the app controllers
 * 
 * 
 * 
 * 
 */
presentItApp.controller('LandingCtrl', function($scope) {
	$scope.message = "Really!!";
});

presentItApp.controller('RootCtrl',
		function($scope, $location) {
	$scope.msg = "Yo!!"
});