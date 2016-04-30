(function(angular) {
	angular.module('carPartsApp.services', [])
	.service('ProductService', function($http, $q){

		var deferred = $q.defer();

		return {
			getProducts: function() {
			 $http.get('/shop/products')
		        .then(function successCallback(result) {
		        	console.log("service.js:getProducts result: ", result.data);
		            deferred.resolve(result.data);
		        }, function errorCallback(errorLog) {
		        	console.log("service.js:getProducts error", errorLog);
		            deferred.reject("service.js:getProducts error")
		        });
		        return deferred.promise;
			}
		}

	})

	.service('ProductDetailsService',function($http,$q){
		// calls /products REST service on backend and stores retrieved data in $scope.productsArray variable
		var deferred = $q.defer();

		return {
			getProduct: function(id) {
		    $http.get('/shop/product/' + id)
		        .then(function successCallback(result) {
		        	console.log("service.js:getProduct result: ", result.data);
		            deferred.resolve(result.data);
		        }, function errorCallback(errorLog) {
		        	console.log("service.js:getProduct error", errorLog);
		            deferred.reject("service.js:getProduct error")
		        });
		        return deferred.promise;
			}

		

			


		}


	});
}(angular));