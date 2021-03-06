package com.polytech.polynet.repository;

import com.polytech.polynet.model.Task;

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
    public List<Task> findAllTasks(String username) {
        Query query = TaskEntityManager.createQuery("SELECT s FROM Task s WHERE s.username = :username")
                .setParameter("username", username);
        return query.getResultList();
    }

    @Override
    public void insertTask(Task task) {
        TaskEntityManager.persist(task);
    }

    @Override
    public void deleteTask(int id) {
        TaskEntityManager.createQuery("DELETE FROM Task WHERE id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
    }

    @Override
    public void updateTask(int id, String content) {
        TaskEntityManager.createQuery("UPDATE Task SET content = :content WHERE id = :id")
                .setParameter("content", content)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void checkTask(int id, boolean done) {
        TaskEntityManager.createQuery("UPDATE Task SET done = :done WHERE id = :id")
                .setParameter("done", done)
                .setParameter("id", id)
                .executeUpdate();
    }
}