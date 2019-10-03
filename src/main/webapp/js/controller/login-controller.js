appEntra21.controller("loginController", function($scope, $http, $window,
		$location) {

	$scope.usuario = {};
	$scope.mensagem = ""
	var urlApi = 'rest/login/autenticar/'

	$scope.autenticar = function() {

		$http.post(urlApi, $scope.usuario).then(
				function(response) {

					console.log(response.data);

					if (response.data.email == $scope.usuario.email
							&& response.data.senha == $scope.usuario.senha) {
						$location.path('despesas');

					}

				}, function(response) {
					console.log(response.status);
					if (response.status == '500') {
						alert("Verificar usuario ou senha")
						$scope.mensagem = "Verificar usuario ou senha"
					}
				});

		this.logout = function() {
			$rootScope.response.data = null;
			$location.path('indexview')
		}
	}
});