(function(angular){

	/**
	 * SearchProductController
	 */
	var SearchProductController = function($scope,$location,$window,$http,localStorageService){

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
	}

	SearchProductController.$inject = ['$scope','$location','$window','$http','localStorageService'];
	angular.module("carPartsApp.controllers").controller("SearchProductController", SearchProductController);

}(angular));