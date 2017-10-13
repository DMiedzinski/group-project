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
        .when('/confirm/:token', {
                controller: 'ConfirmController',
                templateUrl: 'confirm.html'
        })
        .when('/reset',
            {
                controller: 'ResetController',
                templateUrl: 'reset.html'
            })
        .otherwise({redirectTo: '/'});

});


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
            $location.path('/profil');
            $scope.loginFailed = false;
        }, function errorCallback(response) {
            $scope.loginFailed = true;
        });
        $scope.credentials = {};

    };
});

badugi.controller("ConfirmController", function ($http, $scope, $routeParams, $location) {

    console.log("confirm");
    var token = $routeParams.token;

    $scope.confirm = function () {
        $http.get('/api/users/'  + token)
            .success(function (response) {
                $location.path("/login");
            });
    };




})

badugi.controller("RegisterController", function($scope, $rootScope, $window, $http, $httpParamSerializer){
    console.log("Register controller");
    $scope.req = {};
    $scope.register1 = function() {
        var request = {
            method: 'POST',
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

                },
                function errorCallback(response) {
                    $location.path('/login');

                    $scope.error = response.message;
                });
        $scope.req = {};

    };
});

badugi.controller("ProfilController", function($scope,$location, $rootScope, $window, $http, $httpParamSerializer){

    $scope.logout = function() {

        $http
            .post('/api/logout', {})
            .success(function(response) {
                $rootScope.authenticated = false;
                $location.path("/login");
            })
            .error(function(err) {
                $rootScope.authenticated = true;
            });

    };

    $scope.req = {};
    $scope.join = function() {
        var request = {
            method: 'GET',
            url: '/api/users/register',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            data: $httpParamSerializer($scope.req)
        };
    };
});

/*badugi.controller("ProfilController", function($scope, $rootScope, $window, $http, $httpParamSerializer){

    $scope.req = {};
    $http
        .get('/api/users/takeone')
        .then(function (response) {
            $scope.user = response.data;
        });

});*/

badugi.controller("ResetController", function($scope, $rootScope, $window, $http, $httpParamSerializer){
    console.log("Reset controller");
    $scope.credentials = {};
    $scope.reset = function() {
        var request = {
            method: 'POST',
            url: '/api/users/reset',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            data: $httpParamSerializer($scope.credentials)
        };

        $http(request)
            .then(function successCallback(response) {
                    $rootScope.user = response.data;
                    console.log("Reset complete");
                    $location.path('/reset1');
                },
                function errorCallback(response) {
                    $scope.error = response.message;
                });

        $scope.credentials = {};

    };
});


