appEntra21.controller("usuarioController", function($scope, $http) {

$scope.totalDespesa = {};
$scope.totalRenda = {};
$scope.listaUsuario = [];
$scope.usuario = {};

var urlApi = 'http://localhost:8080/walletControl/rest/';

$scope.salvarUsuario = function() {
	var metodo = 'POST';

	if ($scope.usuario.id) {
		metodo = 'PUT';
	}

	$http({
		method : metodo,
		url : urlApi + 'usuarios/',
		data : $scope.usuario
	}).then(function(response) {
		$scope.listaUsuario.push(response.data);
		// $scope.listarUsuarios();
	}, function(response) {
		console.log('error do salvar');
		console.log(response.data);
		console.log(response.status);
	});
};

$scope.verficarUsuario = function() {
	$http({
		method : 'GET',
		url : urlApi + 'usuarios/'
	}).then(function(response) {
		$scope.listaUsuario = response.data;
	}, function(response) {
		console.log('error');
		console.log(response.data);
		console.log(response.status);
	});

};

$scope.totalDespesas = function() {
	$http({
		method : 'GET',
		url : urlApi + 'despesas/soma/'
	}).then(function(response) {
		$scope.totalDespesa = response.data;
	}, function(response) {
		console.log('error - totalDespesa')
	});
};

$scope.totalRendas = function() {
	$http({
		method : 'GET',
		url : urlApi + 'rendas/soma/'
	}).then(function(response) {
		$scope.totalRenda = response.data;
	}, function(response) {
		console.log('error - totalRenda')
	});
};

});