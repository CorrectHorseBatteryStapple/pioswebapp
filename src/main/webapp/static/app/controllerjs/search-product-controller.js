(function(angular){

	/**
	 * SearchProductController
	 */
	var SearchProductController = function($scope, ProductService,$location){

		var vm = this;
		
	    $scope.message = "This is search product page for signed in users";
	    getProducts();



		function getProducts(){
			ProductService.getProducts().then(function(result) {
                $scope.availableProducts = result;
            }, function(error){
                console.log("#routeProvider error", error);
            });
		}

		vm.goTodetailsUrl = function(id){

			console.log("nesto");

			var url = "/search/product-details/";

			var urlFinal = url + id ;

			$location.path(urlFinal);

			console.log(urlFinal);


		}
	}

	SearchProductController.$inject = ['$scope', 'ProductService','$location'];
	angular.module("carPartsApp.controllers").controller("SearchProductController", SearchProductController);

}(angular));