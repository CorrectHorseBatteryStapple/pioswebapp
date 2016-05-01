(function(angular){

	/**
	 * LandingController for anonymous page visit
*/
	var LandingController = function($scope,$http){
	    

	   var vm = this;
	    vm.message = "Welcome to Car Parts Unlimited.";
	    vm.message2 = "Please register or sign up for further page access.";
	    vm.successRegisterMessage = "Registration successful!";
	    vm.successRegisterMessage2 = "Welcome to Car Parts Unlimited,";
	    vm.successRegisterMessage3 = "please log in so we can get started!";

	    	vm.formInfo = {}

	    	vm.isRegistered = false;

	    	
	        vm.saveData=function(){

	    	console.log("landing-controller.js logging log", vm.formInfo);

	    	var url = "/register"


	    	$http.post(url, vm.formInfo).then(function successCallback(result) {
					console.log("success: ", result.data)
					vm.isRegistered = true;
			}, function errorCallback(error) {
					console.log("error: ", error)
					vm.isRegistered = false;
			})
			

	    }

	    };
	    
	  

	LandingController.$inject = ['$scope','$http'];

	angular.module("carPartsApp.controllers").controller("LandingController", LandingController);



}(angular));
