(function(angular){

	/**
	 * LandingController for anonymous page visit
	 */
	/* var loginController = function($scope,user,auth){

		var self = this;

		  function handleRequest(res) {
		    var token = res.data ? res.data.token : null;
		    if(token) { console.log('JWT:', token); }
		    self.message = res.data.message;
		  }

		  self.login = function() {
		    user.login(self.username, self.password)
		      .then(handleRequest, handleRequest)
		  }
		  self.register = function() {
		    user.register(self.username, self.password)
		      .then(handleRequest, handleRequest)
		  }
		  
		  
		  self.logout = function() {
		    auth.logout && auth.logout()
		  }
		  self.isAuthed = function() {
		    return auth.isAuthed ? auth.isAuthed() : false
		  } 

	    $scope.message = "This is login controller page for anonymous page visit. Please register or sign up for further page access.";
	  */
	    //console.log("landing-controller.js logging log", $route.current.locals.bla);
	}

	loginController.$inject = ['$scope'];
	angular.module("carPartsApp.controllers").controller("loginController", loginController);



	

}(angular));
