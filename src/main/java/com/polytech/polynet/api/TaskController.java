package com.polytech.polynet.api;

import com.polytech.polynet.business.Task;
import com.polytech.polynet.business.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/getTasks")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping("/insertTask")
    public void insertTask(@RequestBody Task task){
        taskService.insertTask(task);
        }

    @PostMapping("/deleteTask")
    public void deleteTask(@RequestBody Task task) {
        taskService.deleteTask(task);
    }
}


