(function(angular){
    // create the module and name it carPartsApp
    angular.module("carPartsApp.controllers", []);
    angular.module("carPartsApp.services", []);

    angular.module('carPartsApp', ['ngRoute', 'carPartsApp.controllers', 'carPartsApp.services','ngMessages','ui.bootstrap','LocalStorageModule'])
  //  angular.module('carPartsApp', ['ngMessages']);
    
    // configure angular page router
    .config(function($routeProvider) {

        console.log("app.js init app config")
    	$routeProvider
    		.when('/', {
    			templateUrl : 'static/pages/landing.html',
    			controller : 'LandingController as landCtrl'
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
            .when('/admin', {
                templateUrl : 'static/pages/admin.html',
                controller : 'administrationController as adminCtrl'
            })
            .otherwise({redirectTo: '/'});
            })




            .run(function ($rootScope,$http,$window,localStorageService) {

                $rootScope.usernameField="";
                $rootScope.passwordField="";

                $rootScope.userLoggedIn= localStorageService.get("isLoggedIn");

                $rootScope.loginUser=function () {

                 
                    var user=$rootScope.usernameField;
                    var pass=$rootScope.passwordField;
                    var loginData={ username:user,password:pass};

                console.log("username: ",$rootScope.usernameField,"password: ",$rootScope.passwordField);

               // var urlParams='?username=' + user + '&password=' + pass;
               
                $http.post('/login', loginData)
                .then(function successResponce(responce) {

                    console.log("success", responce.data)
                    if(responce.data.data == null) {
                        $window.alert("Korisnik ne postoji");
                        return;
                    }
                    else{

                        $rootScope.userLoggedIn=true;
                        
                         localStorageService.set("isLoggedIn", true);
                         
                        console.log("logged in state: ", $rootScope.userLoggedIn)
                        $window.location.href="/#/search";
                    }


                }, function errorResponce(error) {
                    console.log("Došlo je do greške kod pristupa stranici!",error);
                    $rootScope.usernameField=false;

                        
                });
          }

            $rootScope.logoutUser=function(){

                    
                    $rootScope.userLoggedIn=null;
                    localStorageService.clearAll();
                    $window.location.href="/#";

                }    

 

/*
    function authInterceptor(API, auth) {
  return {
    // automatically attach Authorization header
    request: function(config) {
      return config;
    },

    // If a token was sent back, save it
    response: function(res) {
      return res;
    },
  }
}

function authService($window) {
  var self = this;

  // Add JWT methods here
}

 }




  )
            .factory('authInterceptor', authInterceptor)

  .constant('API','http://localhost:8080/#/') 
  .config(function($httpProvider) {
  $httpProvider.interceptors.push('authInterceptor');

  */
})  

}(angular));