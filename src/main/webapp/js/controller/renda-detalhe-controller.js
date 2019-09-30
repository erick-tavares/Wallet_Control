appEntra21.controller("rendaDetalheController", function($scope, $http, $routeParams) {

	$scope.rendaDetalhe = {};
	var url = 'http://localhost:8080/walletControl/rest/rendas/';

		$http.get(url + $routeParams.id).then(function(response) {
			$scope.rendaDetalhe = response.data;
			console.log('success - rendaDetalheController');
		}, function(response) {
			console.log('error- rendaDetalheController');
		});
			
		$scope.editarRenda = function() {
			$http({
				method : 'PUT',
				url : url,
				data : $scope.rendaDetalhe
			}).then(function(response) {
				$scope.listaRenda.push(response.data);
				$scope.listarRenda();
			}, function(response) {
				console.log('error - salvarRenda');
			});
		};
});