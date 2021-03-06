package com.polytech.polynet.repository;

import com.polytech.polynet.model.Task;

import java.util.List;

public interface TaskRepository {

    List<Task> findAllTasks(String username);

    void insertTask(Task task);

    void deleteTask(int id);
    
    void updateTask(int id, String content);

    void checkTask(int id, boolean done);

}
