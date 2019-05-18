package com.polytech.polynet.business;

import com.polytech.polynet.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> getTasks();

    void insertTask(Task task);

    void deleteTask(Task task);

}
