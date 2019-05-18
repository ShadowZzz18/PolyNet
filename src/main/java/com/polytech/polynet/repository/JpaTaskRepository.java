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
    EntityManager entityManager;

    public JpaTaskRepository(DataSource datasource) {
        this.datasource = datasource;
    }

    @Override
    public List<Task> findAllTasks() {
        Query query = entityManager.createQuery("SELECT s FROM Task s");
        return query.getResultList();
    }

    @Override
    public void save(Task task) {
        entityManager.persist(task);
    }

}