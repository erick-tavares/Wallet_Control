appEntra21.controller("despesaDetalheController", function($scope, $http, $routeParams) {

	$scope.despesaDetalhe = {};
	var url = 'http://localhost:8080/walletControl/rest/despesas/';

		$http.get(url + $routeParams.id).then(function(response) {
			$scope.despesaDetalhe = response.data;
			console.log('success - despesaDetalheController');
		}, function(response) {
			console.log('error- despesaDetalheController');
		});
});