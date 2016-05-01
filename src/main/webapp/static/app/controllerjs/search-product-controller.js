(function(angular){

	/**
	 * SearchProductController
	 */
	var SearchProductController = function($scope,$location,$window,$http,localStorageService,growl){

		$scope.availableProducts = [];

		var vm = this;

		vm.isAdmin = localStorageService.get("userRole")=="Administrator" ? true : false;
		
	    $scope.message = "This is search product page for signed in users";
	    

	    vm.searchKeyword = "";

		var getProducts = function (){
			$http.get('/shop/products')
	        .then(function successResponse(response) {
	        console.log("getProducts result: ", response.data);
	        $scope.availableProducts = response.data;
	        },

	        function errorResponse(response){
	         console.log("getProducts errorResponse: ", response);

	        });

		}

		getProducts();

		vm.goTodetailsUrl = function(id){

			

			var url = "#/search/product-details/";

			var urlFinal = url + id ;

			$window.location.href=urlFinal;
			//$location.path(urlFinal);

			console.log("search controller ", urlFinal);


		}


		vm.addToCart = function(id) {

			var urlCart = "/cart/update/";

			var userID = localStorageService.get("userId");

			$http.get(urlCart + userID + "/" + id)
			.then(function successResponse(response) {
	        console.log("added to cart result: ", response.data);
	         	growl.success("<b>Item </b> has been added to your cart.");
	        },

	        function errorResponse(response){
	         console.log("cart add errorResponse: ", response);	
	         growl.error("Error.");

	        });


		}
			


	}

	SearchProductController.$inject = ['$scope','$location','$window','$http','localStorageService','growl'];
	angular.module("carPartsApp.controllers").controller("SearchProductController", SearchProductController);

}(angular));