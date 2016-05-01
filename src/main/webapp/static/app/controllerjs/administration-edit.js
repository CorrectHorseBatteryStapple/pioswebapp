(function(angular){

	/**
	 * admin controller
	 */
	var administrationEditController = function($scope,$location,$window,$http,localStorageService,$route){


		var vm = this;

		vm.isAdmin = localStorageService.get("userRole")=="Administrator" ? true : false;

		$scope.product= {};

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

	administrationEditController.$inject = ['$scope','$location','$window','$http','localStorageService','$route'];
	angular.module("carPartsApp.controllers").controller("administrationEditController", administrationEditController);

}(angular));
