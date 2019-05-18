package com.polytech.polynet.api;

import com.polytech.polynet.business.AccountService;
import com.polytech.polynet.business.Task;
import com.polytech.polynet.business.TaskService;
import com.polytech.polynet.business.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    AccountService accountService;

    @Autowired
    TaskService taskService;

    @GetMapping("/getTasks")
    public List<Task> getTasks() {
        //String username = principal.getName();
        return taskService.getTasks();
    }

    @PostMapping("/story")
    public void share(@RequestBody String content){
        taskService.share(new Task(content));
        }

    @PostMapping("/login")
    public void log(String username, String password) {
    }

    @PostMapping("/register")
    public void register(@RequestBody User user){
        System.out.println(user);
        accountService.register(user);
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        System.out.println(accountService.getUsers());
        return accountService.getUsers();
    }

}


