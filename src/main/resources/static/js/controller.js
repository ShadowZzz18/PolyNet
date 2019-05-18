angular.module('Polynet', []).controller('MainController', function ($scope, $http) {

    $scope.register = function() {
        var username = $scope.username;
        var password = $scope.password;
        var verif = $scope.verif;

        if(verif != password){
            return;
        }

        var req = {
            username : username,
            password : password
        };

        $http.post("/register", req)
            .success(function(res) {
                console.log("register succeed");
            })
            .error(function(err) {
                console.log(err);
            })


    }
});