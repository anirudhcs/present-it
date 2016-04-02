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

var app = angular.module('app', [ 'ngRoute' ]).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/', {
				templateUrl : '/signin.html',
				controller : 'LandingCtrl'
			}).when('/home', {
				templateUrl : '/home.html',
				controller : 'HomeCtrl'
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
app.controller('LandingCtrl', function($scope) {
	$scope.msg = "Really!!";
});

app.controller('HomeCtrl', function($scope,$rootScope) {
	var auth2 = gapi.auth2.getAuthInstance();
	console.log(auth2.currentUser.get().isSignedIn());
	var profile = auth2.currentUser.get().getBasicProfile();
	$scope.mesg = profile.getName();
});
app.controller('RootCtrl',
		function($scope, $location, $http) {
	var user;
	$scope.show = true;
	$scope.hide = false;
	
	$scope.msg = "Yo!!";
	
	
	$scope.getSignedInState = function(){
		return user.isSignedIn();
	};
	
	$scope.signIn = function(){
		var auth2 = gapi.auth2.getAuthInstance();
	    auth2.signIn().then(function(googleUser){
	    	user = googleUser;
	    	$scope.show = false;
			$scope.hide = true;
		    $location.path("/home");
		    var profile = user.getBasicProfile();
	    	$scope.msg = profile.getName();
	    	auth2.grantOfflineAccess({'redirect_uri': 'postmessage'}).then(function(authResult) {
	  		  if (authResult['code']) {
	  		    //$http.post('/someUrl', authResult['code']).then(successCallback, errorCallback);  
	  		  } else {
	  		    // There was an error.
	  		  }
	  	});
    	gapi.auth.authorize({client_id: '210330844927-r3p153soqj082oi4igbmnuifnq0dj9ov.apps.googleusercontent.com',
            scope: 'https://www.googleapis.com/auth/userinfo.email', immediate: false},
            function(){});
    	
	    },function(error){});
	    
	    
	    
	};
	
	
	
	$scope.signOut = function(){
	    var auth2 = gapi.auth2.getAuthInstance();
	    auth2.signOut().then(function(){
	    },function(error){});
	    
	    $location.path("/");
	    $scope.msg = "Yo!";
	    $scope.show = true;
		$scope.hide = false;
	};
	
	$scope.sayHello = function(){
		gapi.client.helloworldendpoints.sayHelloByName().execute(function(resp) {
			  $scope.msg = resp.message;
			  console.log("Hello");
		});
	};
	
});

/*
 * When helloworldendpoints API has loaded, this callback is called.
 * 
 * We need to wait until the helloworldendpoints API has loaded to
 * enable the actions for the buttons in index.html,
 * because the buttons call functions in the helloworldendpoints API
 */
//function loadCallback () {	
//	// Enable the button actions
//	enableButtons ();
//}
//
//function enableButtons () {
//	// Set the onclick action for the first button
//	btn = document.getElementById("input_greet_generically");
//	btn.onclick= function(){greetGenerically();};
//	
//	// Update the button label now that the button is active
//	btn.value="Click me for a generic greeting";
//	
//	// Set the onclick action for the second button
//	btn = document.getElementById("input_greet_by_name");
//	btn.onclick=function(){greetByName();};
//
//	// Update the button label now that the button is active
//	btn.value="Click me for a personal greeting";
//	
//	btn = document.getElementById("input_greet_by_period");
//	btn.onclick=function(){greetByPeriod();};
//
//	// Update the button label now that the button is active
//	btn.value="Click me for a period based greeting";
//}
//
///*
// * Execute a request to the sayHello() endpoints function
// */
//function greetGenerically () {
//	// Construct the request for the sayHello() function
//	var request = gapi.client.helloworldendpoints.sayHello();
//	
//	// Execute the request.
//	// On success, pass the response to sayHelloCallback()
//	request.execute(sayHelloCallback);
//}
//
///*
// * Execute a request to the sayHelloByName() endpoints function.
// * Illustrates calling an endpoints function that takes an argument.
// */
//function greetByName () {
//	// Get the name from the name_field element
//	var name = document.getElementById("name_field").value;
//	
//	// Call the sayHelloByName() function.
//	// It takes one argument "name"
//	// On success, pass the response to sayHelloCallback()
//	var request = gapi.client.helloworldendpoints.sayHelloByName({'name': name});
//	request.execute(sayHelloCallback);
//}
//
//function greetByPeriod () {
//	// Get the name from the name_field element
//	var name = document.getElementById("name_field").value;
//	var time = document.getElementById("time_field").value;
//	
//	// Call the sayHelloByName() function.
//	// It takes one argument "name"
//	// On success, pass the response to sayHelloCallback()
//	var request = gapi.client.helloworldendpoints.saysHelloByPeriod({'name': name,'time':time});
//	request.execute(sayHelloCallback);
//}
//
//// Process the JSON response
//// In this case, just show an alert dialog box
//// displaying the value of the message field in the response
//function sayHelloCallback (response) {
//	alert(response.message);	
//}



