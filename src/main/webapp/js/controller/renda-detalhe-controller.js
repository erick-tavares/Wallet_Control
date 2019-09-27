appEntra21.controller("rendaDetalheController", function($scope, $http, $routeParams) {

	$scope.rendaDetalhe = {};
	var url = 'http://localhost:8080/walletControl/rest/rendas/';

		$http.get(url + $routeParams.id).then(function(response) {
			$scope.rendaDetalhe = response.data;
			console.log('success - rendaDetalheController');

		}, function(response) {
			console.log('error- rendaDetalheController');
		});
});