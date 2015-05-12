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
	$http.get(
			URI + "results")
			.success(function(response) {
				$scope.results=response;
			});
	$scope.processForm = function(data){
        $http.post(URI + "competition", angular.toJson($scope.competition)).success(function(response){
        	$scope.result = response.mensaje;
        });
	};
	$scope.addMatch = function(){
		if(!$scope.competition) {
			$scope.competition = {
				matchs: new Array()
			};
		} else if(!$scope.competition.matchs){
			$scope.competition.matchs = new Array();
		}
		$scope.competition.matchs.push({
			result:null,
			date:null,
			local:null,
			visitor:null
		});
	}
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
			URI + "results")
			.success(function(response) {
				$scope.results=response;
			});
	$http.get(
			URI + "competition/" + $routeParams.competititonID)
			.success(function(response) {
				$scope.competition=response;
			});
	$scope.processForm = function(data){
        $http.put(URI + "competition", angular.toJson($scope.competition)).success(function(response){
        	$scope.result = response.mensaje;
        });
	};
	$scope.addMatch = function(){
		alert("Añado partido");
	}
});

PwitterControllers.controller('CompetitionDetailController', function($scope, $http, $routeParams) {
	$http.get(
			URI + "competition/" + $routeParams.competititonID)
			.success(function(response) {
				$scope.competition=response;
			});
});

