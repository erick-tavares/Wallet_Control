appEntra21.controller("loginController", function ($scope, $http, $window, $location) {

    $scope.usuario = {};
    var urlApi = 'rest/login/autenticar/'

    $scope.autenticar = function () {



        $http.post(urlApi, $scope.usuario).then(
            function (response) {

                console.log(response.data);

                if (response.data.email == $scope.usuario.email &&
                    response.data.senha == $scope.usuario.senha) {
                    $location.path('despesas');

                    console.log("indo para outra tela");
                }

            },
            function (response) {
                console.log("falha " + response);
            });






    }
});

appEntra21.controller("loginController", function ($scope, $http, $window, $location) {

    $scope.usuario = {};
    var urlApi = 'rest/login/autenticar/'

    $scope.autenticar = function () {

        $http.post(urlApi, $scope.usuario).then(
            function (response) {

                console.log(response.data);

                if (response.data.email == $scope.usuario.email &&
                    response.data.senha == $scope.usuario.senha) {
                    $location.path('despesas');
                }
            },
            function (response) {
                console.log("falha " + response);
            });
    }
});

