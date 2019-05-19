angular.module('Polynet', []).controller('MainController', function ($scope, $http) {

    $scope.tasks = [];
    $scope.modalIndex = null;

    $scope.setModalFocus = function(id) {
        $scope.modalIndex = id;
    };

    $scope.register = function() {
        var username = $scope.username;
        var password = $scope.password;
        var verif = $scope.verif;

        if(verif != password) {
            $scope.errorRegister = "Passwords are different";
            return;
        }

        var req = {
            username : username,
            password : password
        };

        $http.post("/register", req)
            .success(function(res) {
                console.log(res);
                location.href = "/todolist";
            })
            .error(function(err) {
                console.log(err.status);
                if(err.status == 500) {
                    $scope.errorRegister = "User already exists";
                }
            });
    };

    $scope.getTasks = function() {
        $http.get('/getTasks').then(function(res) {
            $scope.tasks = res.data;
        });
    };

    $scope.insertTask = function() {
        var content = $scope.TaskContent;
        var done = false;

        var req = {
            content : content,
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

    $scope.verifLogin = function() {
        var param = location.search.split('?')[1];
        console.log(param);
        if(param)
            $scope.errorLogin = "Authentication failure";
    };

    $scope.updateTask = function(index) {

        var TaskToUpdate = $scope.tasks[index];
        TaskToUpdate.content = $scope.EditContent;
        $scope.EditContent = "";

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
    };

    $scope.checkTask = function(index) {

        var TaskToCheck = $scope.tasks[index];
        TaskToCheck.done = !TaskToCheck.done;

        var req = {
            id : TaskToCheck.id,
            done : TaskToCheck.done
        };

        $http.post('/checkTask',req).then(function(res) {
            if(TaskToCheck.done) {
                console.log(res);
                console.log(TaskToCheck.content + ' checked');
            }

           if(!TaskToCheck.done){
               console.log(res);
               console.log(TaskToCheck.content + ' unchecked');
            }

            $scope.getTasks();
        }, function(res) {
            console.log("error");
        })
    };

    $scope.getTasks();

});
