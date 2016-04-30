(function(angular){

	/**
	 * SearchProductController
	 */
	var productDetailsController = function($scope, ProductService,$route){

		var vm = this;

		console.log($route.current.params.id);

		var productID = $route.current.params.id;

		getProductDetails();

		

		function getProductDetails(){
			ProductService.getProduct(productID).then(function(result) {
                $scope.product = result;
            }, function(error){
                console.log("#routeProvider error", error);
            });
		}

		
	    
	}

	productDetailsController.$inject = ['$scope','ProductService','$route'];
	angular.module("carPartsApp.controllers").controller("productDetailsController", productDetailsController);

}(angular));