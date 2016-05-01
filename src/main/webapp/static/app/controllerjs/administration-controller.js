(function(angular){

	/**
	 * admin controller
	 */
	var administrationController = function($scope,$location,$window,$http,localStorageService){


		$scope.availableProducts = [];

		var vm = this;

		vm.message = "Add new";
	    vm.message2 = "item ";

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



		vm.deleteItem = function(index){
			var urlDelete = "/shop/product/delete/";
			var idToDelete = $scope.availableProducts[index].id
			console.log('Deleting id', idToDelete)
			$http.delete(urlDelete + idToDelete);

			$scope.availableProducts.splice(index,1);

			$window.location.href = "#/admin";
		}


		vm.formInfo = {}

		vm.addItem = function(){

			console.log("admin-controller.js logging log", vm.formInfo);

			var urlAdd = "/product/edit";

			$http.post(urlAdd, vm.formInfo).then(function successCallback(result) {
					console.log("success: ", result.data)
					
			}, function errorCallback(error) {
					console.log("error: ", error)
					
			})

		}

		vm.editItem = function(id) {


			console.log("admin-controller.js edit log");

			var urlEdit = "#/admin/administrationEdit/";

			var urlEditFinal = urlEdit + id ;

			$window.location.href=urlEditFinal;
			//$location.path(urlFinal);

			console.log("search controller ", urlEditFinal);

		}



	}

	administrationController.$inject = ['$scope','$location','$window','$http','localStorageService'];
	angular.module("carPartsApp.controllers").controller("administrationController", administrationController);

}(angular));
