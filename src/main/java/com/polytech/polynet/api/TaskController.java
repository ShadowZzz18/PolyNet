package com.polytech.polynet.api;

import com.polytech.polynet.business.Task;
import com.polytech.polynet.business.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

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

}


