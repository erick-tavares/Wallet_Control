var appIndex = angular.module("appTeste", ['ngRoute']);

appIndex.config(function($routeProvider){
	
	$routeProvider
	.when("/chamados",
			{templateUrl:'view/chamado.html',
			controller: 'chamadoController'})
			.otherwise({redirectTo:'/'});
		
})