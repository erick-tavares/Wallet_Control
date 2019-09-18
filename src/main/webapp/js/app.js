var appEntra21 = angular.module("walletControl", ['ngRoute']);

appEntra21.config(function($routeProvider, $locationProvider){
    
	$routeProvider
    .when("/despesas",{templateUrl:'view/despesa.html', controller:'despesaController'})
    .when("/despesas/:id",{templateUrl:'view/despesa-detalhe.html', controller:'despesaDetalheController'})
    .when("/usuario",{templateUrl:'view/usuario.html', controller:'usuarioController'})
    .otherwise({redirectTo:'/'});
	
	  // enable html5Mode for pushstate ('#'-less URLs)
    $locationProvider.html5Mode(true);
    $locationProvider.hashPrefix('!');
	
}); 