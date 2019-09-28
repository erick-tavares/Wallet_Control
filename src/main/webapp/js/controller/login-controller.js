appEntra21.controller("loginController", function($scope, $http) {

	$scope.usuario={};
	
	$scope.autenticar = function() {
		 
		$http.post("rest/login/autenticar", $scope.usuario).then(
		function(response) {
			console.log("sucesso " + response);
		},
		function(response) {
			console.log("falha " + response);
		});
		
	}
	
}); 