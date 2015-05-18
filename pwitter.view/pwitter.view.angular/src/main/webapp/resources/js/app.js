var PwitterApplication = angular.module('PwitterApp',
		[ 'ngRoute', 'PwitterControllers' ]);

PwitterApplication.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/list', {
		templateUrl : 'views/listCompetitions.html',
		controller : pwitter.controllers.listCompetitionController
	}).when('/detail/:competititonID', {
		templateUrl : 'views/detailCompetition.html',
		controller : pwitter.controllers.detailCompetitionController
	}).when('/add', {
		templateUrl : 'views/addCompetition.html',
		controller : pwitter.controllers.addCompetitionController
	}).when('/edit/:competititonID', {
		templateUrl : 'views/editCompetition.html',
		controller : pwitter.controllers.editCompetitionController
	}).otherwise({
		redirectTo : '/list'
	});
} ]);