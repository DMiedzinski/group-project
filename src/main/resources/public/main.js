var badugi = angular.module('badugi', ['ngRoute']);

badugi.config(function ($routeProvider) {
    $routeProvider
        .when('/login',
            {
                controller: 'LoginController',
                templateUrl: 'login.html'
            })
        .when('/register',
            {
                controller: 'RegisterController',
                templateUrl: 'register.html'
            })
        .when('/home',
            {
                controller: 'ProfilController',
                templateUrl: 'profil.html'
            })
        .when('/game',
            {
                controller: 'GameController',
                templateUrl: 'game.html'
            })
        .when('/reset-password/:token',
            {
            controller:'ResetPasswordController',
            templateUrl:'resetPass.html'
            })
        .otherwise({redirectTo: '/'});

});

badugi.controller('ResetPasswordController', function ($scope, $http, $routeParams) {

    $scope.token = $routeParams.token;


})
badugi.controller('LoginController', function ($scope, $rootScope, $window, $http, $httpParamSerializer) {
    console.log("Login controller");

    $scope.loginFailed = false;
    $scope.credentials = {};
    $scope.login = function(){
        var request = {
            method: 'POST',
            url: '/api/login',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            data: $httpParamSerializer($scope.credentials)
        };
    $http(request)
    .then(function successCallback(response) {
            $rootScope.authenticated = true;
            $rootScope.user = response.data;
            $location.path('/');
            $scope.loginFailed = false;
        }, function errorCallback(response) {
            $scope.loginFailed = true;
        });
        $scope.credentials = {};

    };
    $scope.logout = function() {
        $http
            .post('/api/logout', {})
            .success(function(response) {
                $rootScope.authenticated = false;
                $rootScope.user = {};
            })
            .error(function(err) {
                $rootScope.authenticated = true;
            });
    }
});

badugi.controller("RegisterController", function($scope, $rootScope, $window, $http, $httpParamSerializer){
    console.log("Register controller");
    $scope.req = {};
    $scope.register1 = function() {
        var request = {
            method: 'PUT',
            url: '/api/users/register',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            data: $httpParamSerializer($scope.req)
        };
        $http(request)
            .then(function successCallback(response) {
                    $rootScope.user = response.data;
                    console.log("Register complete")
                $location.path("/login");
                },
                function errorCallback(response) {
                    $scope.error = response.message;
                });
        $scope.req = {};

    };
});