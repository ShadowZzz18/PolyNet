package com.polytech.polynet.repository;

import com.polytech.polynet.business.Task;
import com.polytech.polynet.business.User;

import java.util.List;

public interface TaskRepository {

    List<Task> findAllTasks();
    List<User> findAllUsers();
    void save(Task task);
    void register(User user);

}
