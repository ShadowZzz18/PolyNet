package com.polytech.polynet.business;


import com.polytech.polynet.repository.TaskRepository;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private TaskRepository taskRepository;

    public AccountServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void register(User user) {
        taskRepository.register(user);
    }

    @Override
    public List<User> getUsers() {
        return taskRepository.findAllUsers();
    }

}
