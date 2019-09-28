appEntra21.controller("despesaDetalheController", function($scope, $http, $routeParams) {

	$scope.rendaDetalhe = {};
	var url = 'http://localhost:8080/walletControl/rest/despesas/';

		$http.get(url + $routeParams.id).then(function(response) {
			$scope.despesaDetalhe = response.data;
			console.log('success - despesaDetalheController');

		}, function(response) {
			console.log('error- despesaDetalheController');
		});
		
		
		
		$scope.editarDespesa = function() {


			$http({
				method : 'PUT',
				url : url,
				data : $scope.despesaDetalhe
			}).then(function(response) {
				$scope.listaDespesa.push(response.data);
				$scope.listarDespesa();
			}, function(response) {
				console.log('error - salvarDespesa');
			});
		};
});