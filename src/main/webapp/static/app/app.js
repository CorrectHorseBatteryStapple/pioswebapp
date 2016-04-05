(function(angular){
    // create the module and name it carPartsApp
    angular.module("carPartsApp.controllers", []);
    angular.module("carPartsApp.services", []);

    angular.module('carPartsApp', ['ngRoute', 'carPartsApp.controllers', 'carPartsApp.services'])
    
    // configure angular page router
    .config(function($routeProvider) {
        console.log("app.js init app config")
    	$routeProvider
    		.when('/', {
    			templateUrl : 'static/pages/landing.html',
    			controller : 'LandingController'
                // resolve : {
                //     products: function(ProductService) {
                //         //console.log("app.js resolve Products: ", ProductService.getProducts());
                //         return ProductService.getProducts().then(function(result) {
                //             console.log("routeProvider result", result)
                //             return result;
                //         }, function(error){
                //             console.log("routeProvider error", error)
                //             return error;
                //         });
                //     }
                // }
    		})
    		.when('/search', {
    			templateUrl : 'static/pages/search_product.html',
    			controller : 'SearchProductController'
    		})
    		.when('/order', {
    			templateUrl : 'static/pages/confirm_order.html',
    			controller : 'ConfirmOrderController'
    		})
            .otherwise({redirectTo: '/'});
            })




            .run(function ($rootScope,$http,$window) {

                $rootScope.usernameField="";
                $rootScope.passwordField="";

                $rootScope.loginUser=function () {

                    
                    $rootScope.userLoggedIn= false;
                    
                 
                    var user=$rootScope.usernameField;
                    var pass=$rootScope.passwordField;

                console.log("username: ",$rootScope.usernameField,"password: ",$rootScope.passwordField);

                var urlParams='?username=' + user + '&password=' + pass;
               
                $http.get('/login' + urlParams)
                .then(function successResponce(responce) {

                    console.log("success", responce.data)
                    if(responce.data.data == null) {
                        $window.alert("Korisnik ne postoji");
                        return;
                    }
                    else{

                        $rootScope.userLoggedIn=true;
                        console.log("logged in state: ", $rootScope.userLoggedIn)
                        $window.location.href="/#/search";
                    }


                }, function errorResponce(error) {
                    console.log("Došlo je do greške kod pristupa stranici!",error);
                    $rootScope.usernameField=false;

                        
                });
          },

            $rootScope.logoutUser=function(){

                    $rootScope.userLoggedIn=null;
                    $window.location.href="/#";
                }    

  });   

}(angular));