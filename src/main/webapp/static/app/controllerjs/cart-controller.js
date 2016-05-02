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


		vm.removeItemFromCart = function(productID,index) {

			var urlDelete = "/cart/update/delete/";
			var userID = localStorageService.get("userId");

			console.log('Remove from cart zapocet');

			$http.get(urlDelete + userID + "/" + productID )
			.then(function successResponse(response){
				console.log("cart remove success", response);
					vm.cart.cartProductList.splice(index,1);

					//$window.location.href="#/shop-cart";
					
			}),
			function errorResponce(response){
				console.log("cart remove error", response);

			}

			}


			vm.confirmOrder = function () {

				var urlOrder = "/cart/confirmOrder/";

				var userID = localStorageService.get("userId");

				console.log('Confirm order zatrazen');	

				$http.get(urlOrder + userID )
				 .then(function successResponse(response){
				  console.log("Confirm order success", response);

					 $window.location.href="#/order";
				  }),
				
				function errorResponce(response){
				console.log("Confirm order error", response);

				
				}


			}

			


		}




	cartController.$inject = ['$scope','$location','$window','$http','localStorageService','growl'];
	angular.module("carPartsApp.controllers").controller("cartController", cartController);

}(angular));