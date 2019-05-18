package com.polytech.polynet.repository;

import com.polytech.polynet.business.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class JpaAccountRepository implements AccountRepository {

    private DataSource datasource;

    @PersistenceContext
    EntityManager entityManager;

    public JpaAccountRepository(DataSource datasource) {
        this.datasource = datasource;
    }

    @Override
    public List<User> findAllUsers() {
        Query query = entityManager.createQuery("SELECT s FROM User s");
        return query.getResultList();
    }

    @Override
    public void register(User user) {
        entityManager.persist(user);
    }

}
