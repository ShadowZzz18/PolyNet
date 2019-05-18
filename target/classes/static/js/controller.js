angular.module('Polynet', []).controller('MainController', function ($scope, $http) {

    $scope.tasks = [];

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

    $scope.getTasks = function() {
        $http.get('/getTasks').then(function(res) {
            $scope.tasks = res.data;
        });
    }

    $scope.insertTask = function() {
        var content = $scope.TaskContent;
        var username = "test";

        var req = {
            content : content,
            username : username
        };

        $http.post('/insertTask', req).then(function(res) {
            console.log(res)
            $scope.getTasks()
        }, function(res) {
                console.log(res)
        })
        $scope.TaskContent = '';
    }

    $scope.deleteTask = function(index) {
        var req = {
            task : $scope.tasks[index]
        }

        $http.post('/deleteTask', req).then(function(res) {
            console.log("succeed")
            $scope.getTasks()
        }, function(res) {
            console.log("error")
        })
    }

    $scope.getTasks()
});