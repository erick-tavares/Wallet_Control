var appEntra21 = angular.module("walletControl", ['ngRoute']);

appEntra21.config(function($routeProvider, $locationProvider){
    
	$routeProvider
    .when("/despesas",{templateUrl:'view/despesa.html', controller:'despesaController'})
    .when("/despesas/novo",{templateUrl:'view/despesa-novo.html', controller:'despesaController'})
    .when("/despesas/edit/:id",{templateUrl:'view/despesa-editar.html', controller:'despesaDetalheController'})
    .when("/despesas/:id",{templateUrl:'view/despesa-detalhe.html', controller:'despesaDetalheController'})  
    
    .when("/rendas",{templateUrl:'view/renda.html', controller:'rendaController'})
    .when("/rendas/novo",{templateUrl:'view/renda-novo.html', controller:'rendaController'})
    .when("/rendas/edit/:id",{templateUrl:'view/renda-editar.html', controller:'rendaDetalheController'})
    .when("/rendas/:id",{templateUrl:'view/renda-detalhe.html', controller:'rendaDetalheController'}) 
    
    .when("/usuario",{templateUrl:'view/usuario.html', controller:'usuarioController'})
    .when("/login",{templateUrl:'view/login.html', controller:'loginController'})
    .otherwise({redirectTo:'/'});

	
	  // enable html5Mode for pushstate ('#'-less URLs)
    $locationProvider.html5Mode(true);
    $locationProvider.hashPrefix('!');
	
}); 