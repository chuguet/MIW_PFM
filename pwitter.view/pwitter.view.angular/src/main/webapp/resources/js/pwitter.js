var baseURI = "http://localhost:8080/api/",
	pwitter =  {
		PwitterControllers : angular.module('PwitterControllers', []),
		controllers : {
			addCompetitionController: 'CompetitionAddController',
			editCompetitionController: 'CompetitionEditController',
			detailCompetitionController: 'CompetitionDetailController',
			listCompetitionController: 'CompetitionListController'
		},
		competitionURI : baseURI + "competition",
		resultsURI : baseURI + "results",
		sportsURI : baseURI + "sports",
		countriesURI : baseURI + "countries",
		separator : "/"
}