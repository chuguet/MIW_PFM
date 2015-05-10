var GuitarApp = angular.module('PwitterApp',
		[ 'ngRoute', 'PwitterControllers' ]);

GuitarApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/list', {
		templateUrl : 'views/listCompetitions.html',
		controller : 'CompetitionListController'
	}).when('/detail/:competititonID', {
		templateUrl : 'views/detailCompetition.html',
		controller : 'CompetitionDetailController'
	}).when('/add', {
		templateUrl : 'views/addCompetition.html',
		controller : 'CompetitionAddController'
	}).when('/edit/:competititonID', {
		templateUrl : 'views/editCompetition.html',
		controller : 'CompetitionEditController'
	}).otherwise({
		redirectTo : '/list'
	});
} ]);