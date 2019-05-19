package com.polytech.polynet.api;

import com.polytech.polynet.model.Task;
import com.polytech.polynet.business.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/getTasks")
    public List<Task> getTasks(Principal p) {
        String username = p.getName();
        return taskService.getTasks(username);
    }

    @PostMapping("/insertTask")
    public void insertTask(@RequestBody Task task, Principal p) {
        task.setUsername(p.getName());
        taskService.insertTask(task);
    }

    @PostMapping("/deleteTask")
    public void deleteTask(@RequestBody Task task) {
        taskService.deleteTask(task.getId());
    }

    @PostMapping("/updateTask")
    public void updateTask(@RequestBody Task task){
        taskService.updateTask(task.getId(),task.getContent());
    }

    @PostMapping("/checkTask")
    public void checkTask(@RequestBody Task task) {
        taskService.checkTask(task.getId(),task.isDone());
    }

}


