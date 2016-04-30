(function(angular){

	/**
	 * LandingController for anonymous page visit
*/
	var dropdownController = function($rootScope){
	    

	    $rootScope.items = [
        "The first choice!",
        "And another choice for you.",
        "but wait! A third!"
    ];

	    };
	    
	  

	dropdownController.$inject = ['$rootScope'];

	angular.module("carPartsApp.controllers").controller("dropdownController", dropdownController);



}(angular));