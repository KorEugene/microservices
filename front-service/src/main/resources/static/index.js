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

    $scope.deleteProduct = function (id) {
        $http({
            url: contextPath + 'front/' + id,
            method: 'DELETE'
        }).then(function (response) {
            console.log(response)
            $scope.loadProducts();
        });
    };

    $scope.createProduct = function () {
        if ($scope.new_product == null) {
            alert('Форма не заполнена');
            return;
        }
        $http.post(contextPath + 'front', $scope.new_product)
            .then(function successCallback(response) {
                $scope.new_product = null;
                console.log(response);
                $scope.loadProducts();
            }, function failureCallback(response) {
                console.log(response);
            });
    };

    $scope.updateProduct = function () {
        $http.put(contextPath + 'front', $scope.updated_product)
            .then(function successCallback(response) {
                $scope.updated_product = null;
                console.log(response);
                $scope.loadProducts();
            }, function failureCallback(response) {
                console.log(response);
            });
    };

    $scope.loadProducts();
});