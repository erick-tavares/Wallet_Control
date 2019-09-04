var appIndex = angular.module("appTeste", []);
//criacao do controller
appIndex.controller("indexController", function ($scope, $http) {
   $scope.nome = "Erick";
   $scope.sobreNome = "Tavares";
   
   $scope.listaChamado = [];
   $scope.listarChamados = function () {
       $http({ method: 'GET', url: 'http://localhost:8080/api_proway/rest/chamados/'
       }).then(
           function (response) {
               $scope.listaChamado = response.data;
           },
           function (response) {
               console.log('error');
           });
   };
       
       
  $scope.salvarChamado = function(){
       $http({ method: 'POST', url: 'http://localhost:8080/api_proway/rest/chamados/',
        	data: $scope.chamado
        	   
   }).then(
       function (response) {
           $scope.listaChamado.push ($scope.chamado);
           console.log(response.data);
       },
       function (response) {
           console.log('error');
           console.log(response.data);
       });   
   };
   
   
   $scope.deletarChamado = function (id) {
       $http({ method: 'DELETE', url: 'http://localhost:8080/api_proway/rest/chamados/' + id
       }).then(
           function (response) {
               $scope.deletarChamado = response.data;
           },
           function (response) {
               console.log('error');
           });
   };
   
   
   
   
});