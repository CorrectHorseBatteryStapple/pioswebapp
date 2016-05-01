(function(angular){

	/**
	 * cartController
	 */
	var cartController = function($scope,$location,$window,$http,localStorageService,growl){

	
		var vm = this;

		vm.cart = {}

		var getCart = function (){
			$http.get('/cart/details/' + localStorageService.get("userId"))
	        .then(function successResponse(response) {
	        console.log("cart details result: ", response.data);
	         vm.cart = response.data;
	        },

	        function errorResponse(response){
	         console.log("cart details errorResponse: ", response);

	        });

	    }

	getCart();


	


}

	cartController.$inject = ['$scope','$location','$window','$http','localStorageService','growl'];
	angular.module("carPartsApp.controllers").controller("cartController", cartController);

}(angular));