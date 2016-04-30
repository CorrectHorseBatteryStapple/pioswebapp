(function(angular){

	/**
	 * SearchProductController
	 */
	var productDetailsController = function($scope, ProductService){

		var vm = this;

		detaljiOProizvodu();
		


		
	    
	}

	productDetailsController.$inject = ['$scope','ProductService'];
	angular.module("carPartsApp.controllers").controller("productDetailsController", productDetailsController);

}(angular));