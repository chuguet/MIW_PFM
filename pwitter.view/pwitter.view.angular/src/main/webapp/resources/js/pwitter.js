var PwitterControllers = angular.module('PwitterControllers', []);

PwitterControllers.controller('CompetitionListController', function($scope, $http) {
	$scope.changeRoute = function(url, forceReload) {
        $scope = $scope || angular.element(document).scope();
        if(forceReload || $scope.$$phase) { // that's right TWO dollar signs: $$phase
            window.location = url;
        } else {
            $location.path(url);
            $scope.$apply();
        }
    };
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
					   $scope.changeRoute('#/detail/'+data.id);
				};
			});
});

PwitterControllers.controller('CompetitionDetailController', function($scope, $http, $routeParams) {
	$http.get(
			"http://localhost:8080/api/competition/" + $routeParams.competititonID)
			.success(function(response) {
				$scope.competition=response;
				$scope.closeDetail=function(){
					$scope.competition=undefined;
				};
			});
});

