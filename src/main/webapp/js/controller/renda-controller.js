appEntra21.controller("rendaController", function($scope, $http, $routeParams) {
	
	$scope.listaRenda = [];
	$scope.renda = {};
	$scope.rendaSelecionado = {};
	
	var urlApi = 'rest/rendas/';
	
	$scope.listarRendas = function() {
		$http({
			method : 'GET',
			url : urlApi
		}).then(function(response) {
			$scope.listaRenda = response.data;
		}, function(response) {
			console.log('error - listarRenda');
		});
	};

	$scope.salvarRenda = function() {
		$http({
			method : 'POST',
			url : urlApi,
			data : $scope.renda
		}).then(function(response) {
			$scope.listaRenda.push(response.data);
			$scope.listarRendas();
		}, function(response) {
			console.log('error - salvarRenda');
		});
	};

	$scope.deleteRenda = function(id) {

		$http({
			method : 'DELETE',
			url : urlApi + id
		}).then(function(response) {
			$scope.listaRenda.splice(id, 1);
			$scope.listarRendas();
		}, function(response) {
			console.log('error - deleteRenda');
		});
	};

	$scope.cancelarAlteracaoRenda = function(renda) {
		$scope.renda = {};
	};

});