package com.polytech.polynet.repository;

import com.polytech.polynet.business.Task;

import java.util.List;

public interface TaskRepository {

    List<Task> findAllTasks();

    void save(Task task);

}
