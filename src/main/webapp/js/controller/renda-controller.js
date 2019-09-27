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
			console.log('error - listarRenda')
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
			console.log('error - salvarRenda');
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
			console.log('error - deleteRenda ');
		});
	};

	$scope.cancelarAlteracaoRenda = function(renda) {
		$scope.renda = {};
	};

});