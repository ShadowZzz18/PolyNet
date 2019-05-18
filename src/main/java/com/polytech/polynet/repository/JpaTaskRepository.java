package com.polytech.polynet.repository;


import com.polytech.polynet.business.Task;
import com.polytech.polynet.business.User;


import javax.persistence.*;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
public class JpaTaskRepository implements TaskRepository {

    private DataSource datasource;

    public JpaTaskRepository(DataSource datasource) {
        this.datasource = datasource;
    }

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Task> findAllTasks() {
        Query query = entityManager.createQuery("SELECT s FROM Task s");
        return query.getResultList();
    }

    @Override
    public List<User> findAllUsers() {
        Query query = entityManager.createQuery("SELECT s FROM User s");
        return query.getResultList();
    }

    @Override
    public void save(Task task) {
        entityManager.persist(task);
    }

    @Override
    public void register(User user) {
        entityManager.persist(user);
    }

}