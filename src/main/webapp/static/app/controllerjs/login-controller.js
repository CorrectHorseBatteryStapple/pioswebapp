(function(angular){


	var loginController = function($http,$window,localStorageService,$rootScope){

					 $rootScope.items = [
       				"The first choice!",
       				 "And another choice for you.",
    			    "but wait! A third!"
  					  ];


				var vm = this;
				

				vm.loginData = {}
				
                vm.userLoggedIn= localStorageService.get("isLoggedIn");
                vm.firstName = localStorageService.get("firstNameUser");
                vm.lastName = localStorageService.get("lastNameUser");
                


                vm.loginUser=function () {
                	
                 	
	                console.log("data: ",vm.loginData);

	               // var urlParams='?username=' + user + '&password=' + pass;
	               
	                $http.post('/login', vm.loginData)
	                .then(function successResponce(responce) {

	                    console.log("success", responce)
                    	// JWT token
                    	//$http.defaults.headers.common.Authorization = 'Bearer ' + responce.data.token;
	                    if(responce.data.data == null) {
	                        $window.alert("Korisnik ne postoji");
	                        return;
	                    }
	                    else{

	                        vm.userLoggedIn=true;
	
	                         localStorageService.set("isLoggedIn", true);
	                         localStorageService.set("firstNameUser",responce.data.data.firstname);
	                         localStorageService.set("lastNameUser",responce.data.data.lastname);
	                         
	                         
	                        console.log("logged in state: ", vm.userLoggedIn)
	                        $window.location.href="/#/search";
	                    }


	                }, function errorResponce(error) {
	                    console.log("Došlo je do greške kod pristupa stranici!",error);
	                    

	                        
	                });
         	 }

            vm.logoutUser=function(){

                    
                    vm.userLoggedIn=null;
                    localStorageService.clearAll();
                    $window.location.href="/#";

                }  

	}

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
	

	loginController.$inject = ['$http','$window','localStorageService','$rootScope'];
	angular.module("carPartsApp.controllers").controller("loginController", loginController);



	

}(angular));
