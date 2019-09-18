appEntra21.controller("despesaDetalheController", function($scope, $http,
		$routeParams) {

	$scope.despesaDetalhe = {};
	var url = 'http://localhost:8080/walletControl/rest/despesas/';

		$http.get(url + $routeParams.id).then(function(response) {
			$scope.despesaDetalhe = response.data;
			console.log('success - despesaDetalheController');
			console.log(response.data);
			console.log(response.status);

		}, function(response) {
			console.log('error- despesaDetalheController');
			console.log(response.data);
			console.log(response.status);
		});
});