var app = angular.module('competitionsApp', []);
app.controller('competitionsController', function($scope, $http) {
	$http.get("http://localhost:8080/api/competition").success(
			function(response) {
				$scope.competitions = response;

				$scope.add = function(data) {
					debugger;
				};
				$scope.edit = function(data) {
					debugger;
				};
				$scope.erase = function(data) {
					$http.delete(
							"http://localhost:8080/api/competition/" + data.id)
							.success(function(response) {
								$http.get("http://localhost:8080/api/competition").success(function(response){
									$scope.competitions = response;
								});
								$scope.competition=undefined;
							});
				};
				$scope.detail = function(data) {
					$http.get(
							"http://localhost:8080/api/competition/" + data.id)
							.success(function(response) {
								$scope.competition=response;
								$scope.closeDetail=function(){
									$scope.competition=undefined;
								};
							});
				};
			});
});
