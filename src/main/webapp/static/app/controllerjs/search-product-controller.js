(function(angular){

	/**
	 * SearchProductController
	 */
	var SearchProductController = function($scope, ProductService){
	    $scope.message = "This is search product page for signed in users";
	    getProducts();

		function getProducts(){
			ProductService.getProducts().then(function(result) {
                $scope.availableProducts = result;
            }, function(error){
                console.log("#routeProvider error", error);
            });
		}
	}

	SearchProductController.$inject = ['$scope', 'ProductService'];
	angular.module("carPartsApp.controllers").controller("SearchProductController", SearchProductController);

}(angular));