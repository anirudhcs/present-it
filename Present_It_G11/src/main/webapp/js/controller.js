'use strict';

/**
 * The root presentItApp module.
 *
 * @type {presentItApp|*|{}}
 */
 var presentItApp = presentItApp || {};

/**
 * @ngdoc module
 * @name presentItControllers
 *
 * @description
 * Angular module for controllers.
 *
 */
 presentItApp.controllers = angular.module('presentItControllers', ['ui.bootstrap']);
 
 presentItApp.controllers.controller('LandingCtrl', function ($scope) {
	 $scope.message = "Really!!";
 });