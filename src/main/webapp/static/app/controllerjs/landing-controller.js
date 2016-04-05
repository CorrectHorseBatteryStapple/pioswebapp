(function(angular){

	/**
	 * LandingController for anonymous page visit
	 */
	var LandingController = function($scope){
	    $scope.message = "This is landing page for anonymous page visit. Please register or sign up for further page access.";
	    
	    //console.log("landing-controller.js logging log", $route.current.locals.bla);
	}

	LandingController.$inject = ['$scope'];
	angular.module("carPartsApp.controllers").controller("LandingController", LandingController);

	

}(angular));
