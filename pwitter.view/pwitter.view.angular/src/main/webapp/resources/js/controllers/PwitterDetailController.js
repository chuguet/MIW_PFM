pwitter.PwitterControllers.controller(pwitter.controllers.detailCompetitionController, function($scope, $http, $routeParams) {
	$http.get(
			pwitter.competitionURI + pwitter.separator + $routeParams.competititonID)
			.success(function(response) {
				$scope.competition=response;
			});
});