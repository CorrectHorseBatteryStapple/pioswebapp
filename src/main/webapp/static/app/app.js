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


            .run(function ($rootScope) {
                $rootScope.userLoggedIn= false;

                $rootScope.loginUser=function () {
                    //$rootScope.userLoggedIn=!$rootScope.userLoggedIn;
console.log("blabal2222");
                } 
                $rootScope.go=function () {
                    
                console.log("blabal2222");
                } 
                
                console.log("blabal");
            });

            

            


}(angular));