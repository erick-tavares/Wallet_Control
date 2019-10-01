appEntra21.controller("loginController", function($scope, $http) {

	$scope.usuario={};
	var urlApi = 'http://localhost:8080/walletControl/rest/'
	
	$scope.autenticar = function() {
		 
		$http.post(urlApi+ "login/autenticar/", $scope.usuario).then(
		function(response) {
			console.log($scope.usuario);
			
			$state.go('/rendas');
			console.log("sucesso " + response);
		},
		function(response) {
			console.log($scope.usuario);
			console.log("falha " + response);
		});
		
	}
	
	
	
}); 