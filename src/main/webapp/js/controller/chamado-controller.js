//criacao do controller
appIndex.controller("chamadoController", function ($scope, $http) {
   
   $scope.listaChamado = [];
   $scope.chamado = {};
	   
	   var urlBase = 'http://localhost:8080/api_proway/rest/chamados/'
		   
	   $scopelistarChamados = function () {
       $http({ method: 'GET', url: urlBase
       }).then(
           function (response) {
               $scope.listaChamado = response.data;
           },
           function (response) {
               console.log('error');
           });
   };
       
       
  $scope.salvarChamado = function(){
	  var metodo = 'POST';
	  
	  if ($scope.chamado.id){
		  metodo = 'PUT';
	  }
	  
       $http({ method: metodo, url: urlBase,
        	data: $scope.chamado
        	   
   }).then(
       function (response) {
           $scope.listaChamado.push ($scope.chamado);
       },
       function (response) {
           console.log('error');
       });   
   };
   
   
   $scope.deletarChamado = function (id) {
       $http({ method: 'DELETE', url: urlBase + id
       }).then(
           function (response) {
               $scope.listarChamado;
           },
           function (response) {
               console.log('error do DELETE');
           });
   };
   
   $scopealterarChamado = fuction (chamado){
	   $scope.chamado = chamado;
   };
   
   $scopecancelarAlterarChamado = fuction (){
	   $scope.chamado = {}
   }
   
   
});