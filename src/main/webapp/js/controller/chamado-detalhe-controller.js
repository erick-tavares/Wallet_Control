appEntra21.controller("chamadoDetalheController", function($scope, $http,
		$routeParams) {

	$scope.chamadoDetalhe = {};
	var url = 'http://localhost:8080/wallet_control/rest/chamados/';

		$http.get(url + $routeParams.id).then(function(response) {
			$scope.chamadoDetalhe = response.data;
			console.log('success - chamadoDetalheController');
			console.log(response.data);
			console.log(response.status);

		}, function(response) {
			console.log('error- chamadoDetalheController');
			console.log(response.data);
			console.log(response.status);
		});
});