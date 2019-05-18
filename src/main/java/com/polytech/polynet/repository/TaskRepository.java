package com.polytech.polynet.repository;

import com.polytech.polynet.model.Task;

import java.util.List;

public interface TaskRepository {

    List<Task> findAllTasks();

    void insertTask(Task task);

    void deleteTask(int id);
    
    void updateTask(int id, String content);

}
