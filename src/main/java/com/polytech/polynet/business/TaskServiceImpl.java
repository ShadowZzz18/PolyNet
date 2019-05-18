package com.polytech.polynet.business;

import com.polytech.polynet.repository.TaskRepository;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {

        return taskRepository.findAllTasks();
    }

    @Override
    public void share(Task task) {
        taskRepository.save(task);
    }


}
