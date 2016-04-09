(function(angular){

	/**
	 * ConfirmOrderController
	 */
	var administrationController = function($scope){
	    $scope.message = "This is adnmin page";
	}

	administrationController.$inject = ['$scope'];
	angular.module("carPartsApp.controllers").controller("administrationController", administrationController);

}(angular));
