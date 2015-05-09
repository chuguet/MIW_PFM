var GuitarApp = angular.module('PwitterApp', ['ngRoute','PwitterControllers']);

GuitarApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
  when('/list', {
    templateUrl: 'views/competitionsList.html',
    controller: 'CompetitionListController'
  }).
  when('/detail/:competititonID', {
    templateUrl: 'views/competitionDetail.html',
    controller: 'CompetitionDetailController'
  }).
  otherwise({
    redirectTo: '/list'
  });
}]);