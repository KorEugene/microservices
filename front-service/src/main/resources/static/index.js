angular.module('front', ['ngRoute', 'ngStorage']).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8190/front-service/';

    $scope.loadProducts = function () {
        $http({
            url: contextPath + 'front',
            method: 'GET'
        }).then(function (response) {
            console.log(response);
            $scope.products = response.data;
        });
    };

    $scope.loadProducts();
});