package com.polytech.polynet.business;

import java.util.List;

public interface TaskService {

    List<Task> getTasks();
    void insertTask(Task task);
    void deleteTask(int id);

}
