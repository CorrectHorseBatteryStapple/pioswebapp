(function(angular){

	/**
	 * SearchProductController
	 */
	var productDetailsController = function($scope,$route,$http){

		$scope.product= {};

		var vm = this;

		

		var productID = $route.current.params.id;

		

		var getProductDetails = function (productID){
			$http.get('/shop/product/' + productID)
	        .then(function successResponse(response) {
	        console.log("getProductsDetails result: ", response.data);
	         $scope.product = response.data;
	        },

	        function errorResponse(response){
	         console.log("getProductsDetails errorResponse: ", response);

	        });

		}

		getProductDetails(productID);


	}

	productDetailsController.$inject = ['$scope','$route','$http'];
	angular.module("carPartsApp.controllers").controller("productDetailsController", productDetailsController);

}(angular));