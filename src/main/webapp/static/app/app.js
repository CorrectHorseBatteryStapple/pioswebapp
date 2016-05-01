(function(angular){
    // create the module and name it carPartsApp
    angular.module("carPartsApp.controllers", []);
    angular.module("carPartsApp.services", []);

    angular.module('carPartsApp', ['ngRoute', 'angular-growl', 'carPartsApp.controllers', 'carPartsApp.services','ngMessages','ui.bootstrap','LocalStorageModule','ui.bootstrap'])
  //  angular.module('carPartsApp', ['ngMessages']);
    
    // configure angular page router
    .config(function($routeProvider,growlProvider) {

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
    			controller : 'SearchProductController as searchController'
    		})
            .when('/shop-cart', {
                templateUrl : 'static/pages/shop-cart.html',
                controller : 'cartController as cartCtrl'
            })

            .when('/search/product-details/:id?', {

                templateUrl : 'static/pages/product-details.html',
                controller : 'productDetailsController as detailsController'


            })
    		.when('/order', {
    			templateUrl : 'static/pages/confirm_order.html',
    			controller : 'ConfirmOrderController'
    		})
            .when('/admin', {
                templateUrl : 'static/pages/admin.html',
                controller : 'administrationController as adminCtrl'
            })
            .when('/admin/administrationEdit/:id?', {
                templateUrl : 'static/pages/administrationEdit.html',
                controller : 'administrationEditController as adminEditCtrl'
            })
            .when('/admin/addNewItem', {
                templateUrl : 'static/pages/addNewItem.html',
                controller : 'administrationController as adminCtrl'
            })

            .otherwise({redirectTo: '/'});


             // growlProvider

            growlProvider.globalInlineMessages(true);
            growlProvider.globalTimeToLive({success: 3600, error: -1, warning: 3000, info: 4000});
            growlProvider.globalDisableCountDown(true);
            growlProvider.globalReversedOrder(true);

        });


}(angular));