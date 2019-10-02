appEntra21.controller("cadastroController", function($scope, $http) {

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

});