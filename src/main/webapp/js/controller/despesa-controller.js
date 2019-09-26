appEntra21.controller("despesaController", function($scope, $http, $routeParams) {
	
	$scope.listaDespesa = [];
	$scope.despesa = {};
	$scope.despesaSelecionado = {};
	
	var urlApi = 'http://localhost:8080/walletControl/rest/';
	
	$scope.listarDespesas = function() {
		$http({
			method : 'GET',
			url : urlApi + 'despesas/'
		}).then(function(response) {
			$scope.listaDespesa = response.data;
		}, function(response) {
			console.log('error - listarDespesa')
		});
	};

	$scope.salvarDespesa = function() {
		var metodo = 'POST';

		if ($scope.despesa.id){
			metodo = 'PUT';
		}

		$http({
			method : metodo,
			url : urlApi + 'despesas/',
			data : $scope.despesa
		}).then(function(response) {
			$scope.listaDespesa.push(response.data);
			$scope.listarDespesa();
		}, function(response) {
			console.log('error - salvarDespesa');
		});
	};

	$scope.deleteDespesa = function(id) {

		$http({
			method : 'DELETE',
			url : urlApi + 'despesas/' + id
		}).then(function(response) {
			$scope.listaDespesa.splice(id, 1);
			$scope.listarDespesas();
		}, function(response) {
			console.log('error - deleteDespesa ');
		});
	};

	$scope.cancelarAlteracaoDespesa = function(despesa) {
		$scope.despesa = {};
	};

});