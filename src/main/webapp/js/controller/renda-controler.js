appEntra21.controller("rendaController", function($scope, $http, $routeParams) {
	
	$scope.listaRenda = [];
	$scope.renda = {};
	$scope.rendaSelecionado = {};
	
	var urlApi = 'http://localhost:8080/walletControl/rest/';
	
	$scope.listarRendas = function() {
		$http({
			method : 'GET',
			url : urlApi + 'rendas/'
		}).then(function(response) {
			$scope.listaRenda = response.data;
		}, function(response) {
			console.log('error');
			console.log(response.data);
			console.log(response.status);
		});
	};

	$scope.salvarRenda = function() {
		var metodo = 'POST';

		if ($scope.renda.id){
			metodo = 'PUT';
		}

		$http({
			method : metodo,
			url : urlApi + 'rendas/',
			data : $scope.renda
		}).then(function(response) {
			$scope.listaRenda.push(response.data);
			$scope.listarRenda();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};

	$scope.deleteRenda = function(id) {

		$http({
			method : 'DELETE',
			url : urlApi + 'rendas/' + id
		}).then(function(response) {
			$scope.listaRenda.splice(id, 1);
			$scope.listarRendas();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};

	$scope.alterarRenda = function(renda) {
		$scope.renda = angular.copy(renda);
	}

	$scope.cancelarAlteracaoRenda = function(renda) {
		$scope.renda = {};
	};

});