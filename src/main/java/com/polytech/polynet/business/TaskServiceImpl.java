package com.polytech.polynet.business;

import com.polytech.polynet.model.Task;
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
    public void insertTask(Task task) {
        taskRepository.insertTask(task);
    }

    @Override
    public void deleteTask(int id) { taskRepository.deleteTask(id); }

    @Override
    public void updateTask(int id, String content) {
        taskRepository.updateTask(id,content);
    }


}
