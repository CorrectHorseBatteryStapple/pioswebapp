(function(angular){

	/**
	 * LandingController for anonymous page visit
*/
	var LandingController = function($scope){
	    

	   var vm = this;
	    vm.message = "Welcome to Car Parts Unlimited.";
	    vm.message2 = "Please register or sign up for further page access.";
	    	vm.formInfo = {}


	        vm.saveData=function(){

	    	console.log("landing-controller.js logging log", vm.formInfo);
			

	    }

	    };
	    
	  

	LandingController.$inject = ['$scope'];
	angular.module("carPartsApp.controllers").controller("LandingController", LandingController);



}(angular));
