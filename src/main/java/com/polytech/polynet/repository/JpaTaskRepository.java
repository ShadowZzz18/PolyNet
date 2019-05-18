package com.polytech.polynet.repository;

import com.polytech.polynet.business.Task;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class JpaTaskRepository implements TaskRepository {

    private DataSource datasource;

    @PersistenceContext
    EntityManager TaskEntityManager;

    public JpaTaskRepository(DataSource datasource) {
        this.datasource = datasource;
    }

    @Override
    public List<Task> findAllTasks() {
        Query query = TaskEntityManager.createQuery("SELECT s FROM Task s");
        return query.getResultList();
    }

    @Override
    public void insertTask(Task task) {
        TaskEntityManager.persist(task);
    }

    @Override
    public void deleteTask(Task task) {
       TaskEntityManager.createQuery("DELETE FROM Task WHERE id = :id")
               .setParameter("id", task.getId())
               .executeUpdate();
    }

}