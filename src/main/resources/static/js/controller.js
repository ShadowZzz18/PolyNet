angular.module('Polynet', []).controller('MainController', function ($scope, $http) {

    $scope.tasks = [];

    $scope.register = function() {
        var username = $scope.username;
        var password = $scope.password;
        var verif = $scope.verif;

        if(verif != password) {
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
            });
    };

    $scope.getTasks = function() {
        $http.get('/getTasks').then(function(res) {
            $scope.tasks = res.data;
        });
    };

    $scope.insertTask = function() {
        var content = $scope.TaskContent;
        var username = "test";
        var done = false;

        var req = {
            content : content,
            username : username,
            done : done
        };

        $http.post('/insertTask', req).then(function(res) {
            console.log(res)
            $scope.getTasks()
        }, function(res) {
                console.log(res)
        });
        $scope.TaskContent = '';
    };

    $scope.deleteTask = function(id) {

        var req = {
            id : id
        };

        $http.post('/deleteTask', req).then(function(res) {
            console.log("succeed");
            $scope.getTasks();
        }, function(res) {
            console.log("error")
        });
    };

    $scope.login = function() {
        var req = {
            username : $scope.username,
            password : $scope.password
        };

        $http.post('/loginUser', req).then(function(res) {
            console.log(res);
            if(res.data == "true") {
                console.log("Authentification reussie !")
                //location.href = '/';
            }
        });
    };

    $scope.updateTask = function(index){

        var TaskToUpdate = $scope.tasks[index];
        var contents = document.getElementsByClassName("task-name")
        TaskToUpdate.content = contents[index].value;

        var req = {
            id : TaskToUpdate.id,
            content : TaskToUpdate.content,
        };

        $http.post('/updateTask', req).then(function(res) {
            console.log("succeed")
            $scope.getTasks()
        }, function(res) {
            console.log("error")
        })
    }

    $scope.checkTask = function(index) {

        var TaskToCheck = $scope.tasks[index];
        TaskToCheck.done = !TaskToCheck.done;

        var req = {
            id : TaskToCheck.id,
            done : TaskToCheck.done
        };

        $http.post('/checkTask',req).then(function(res) {
            if(TaskToCheck.done) {
                console.log(res)
                console.log(TaskToCheck.content + ' checked');
            }

           if(!TaskToCheck.done){
               console.log(res)
               console.log(TaskToCheck.content + ' unchecked');
            }
        }, function(res) {
            console.log("error")
        })
    }

    $scope.getTasks()
});
