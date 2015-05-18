pwitter.PwitterControllers.controller(pwitter.controllers.listCompetitionController, function($scope, $http, $location) {
	$http.get(pwitter.competitionURI).success(
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
							pwitter.competitionURI + pwitter.separator + data.id)
							.success(function(response) {
								$http.get(pwitter.competitionURI).success(function(response){
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