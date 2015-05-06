var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http) {
	$http.get("http://localhost:8080/api/competition").success(
			function(response) {
				$scope.competitions = response;
			});
});
