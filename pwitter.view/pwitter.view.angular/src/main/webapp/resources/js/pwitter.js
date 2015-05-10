var PwitterControllers = angular.module('PwitterControllers', []),
	URI = "http://localhost:8080/api/";

PwitterControllers.controller('CompetitionListController', function($scope, $http, $location) {
	$http.get(URI + "competition").success(
			function(response) {
				$scope.competitions = response;

				$scope.add = function(data) {
					$location.path('/add');
				};
				$scope.edit = function(data) {
					$location.path('/edit/'+data.id);
				};
				$scope.erase = function(data) {
					$http.delete(
							URI + "competition/" + data.id)
							.success(function(response) {
								$http.get(URI + "competition").success(function(response){
									$scope.competitions = response;
								});
								$scope.competition=undefined;
							});
				};
				$scope.detail = function(data) {
					$location.path('/detail/'+data.id);
				};
			});
});

PwitterControllers.controller('CompetitionAddController', function($scope, $http, $routeParams) {
	$http.get(
			URI + "sports")
			.success(function(response) {
				$scope.sports=response;
			});
	$http.get(
			URI + "countries")
			.success(function(response) {
				$scope.countries=response;
			});
	$scope.processForm = function(data){
        $http.post(URI + "competition", JSON.stringify($scope.form)).success(function(response){
        	$scope.result = response.mensaje;
        });
	};
});

PwitterControllers.controller('CompetitionEditController', function($scope, $http, $routeParams) {
	$http.get(
			URI + "sports")
			.success(function(response) {
				$scope.sports=response;
			});
	$http.get(
			URI + "countries")
			.success(function(response) {
				$scope.countries=response;
			});
	$http.get(
			URI + "competition/" + $routeParams.competititonID)
			.success(function(response) {
				$scope.competition=response;
			});
	$scope.processForm = function(data){
        $http.put(URI + "competition", JSON.stringify($scope.competition)).success(function(response){
        	$scope.result = response.mensaje;
        });
	};
});

PwitterControllers.controller('CompetitionDetailController', function($scope, $http, $routeParams) {
	$http.get(
			URI + "competition/" + $routeParams.competititonID)
			.success(function(response) {
				$scope.competition=response;
			});
});

