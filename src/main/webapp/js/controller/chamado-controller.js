appEntra21.controller("chamadoController", function($scope, $http) {

	$scope.listaChamado = [];
	$scope.chamado = {};
	var urlApi = 'http://localhost:8080/walletControl/rest/';

	$scope.listarChamados = function() {
		$http({
			method : 'GET',
			url : urlApi + 'chamados/'
		}).then(function(response) {
			$scope.listaChamado = response.data;
		}, function(response) {
			console.log('error');
			console.log(response.data);
			console.log(response.status);
		});
	};

	$scope.salvarChamado = function() {
		var metodo = 'POST';

		if ($scope.chamado.id){
			metodo = 'PUT';
		}

		$http({
			method : metodo,
			url : urlApi + 'chamados/',
			data : $scope.chamado
		}).then(function(response) {
			$scope.listaChamado.push(response.data);
			$scope.listarChamados();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};

	$scope.deleteChamado = function(id) {

		$http({
			method : 'DELETE',
			url : urlApi + 'chamados/' + id
		}).then(function(response) {
			$scope.listaChamado.splice(id, 1);
			$scope.listarChamados();
		}, function(response) {
			console.log('error do salvar');
			console.log(response.data);
			console.log(response.status);
		});
	};

	$scope.alterarChamado = function(chamado) {
		$scope.chamado = angular.copy(chamado);
	}

	$scope.cancelarAlteracaoChamado = function(chamado) {
		$scope.chamado = {};
	};

});