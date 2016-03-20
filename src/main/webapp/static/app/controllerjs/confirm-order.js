(function(angular){

	/**
	 * ConfirmOrderController
	 */
	var ConfirmOrderController = function($scope){
	    $scope.message = "This is confirm order page for signed in users";
	}

	ConfirmOrderController.$inject = ['$scope'];
	angular.module("carPartsApp.controllers").controller("ConfirmOrderController", ConfirmOrderController);

}(angular));
