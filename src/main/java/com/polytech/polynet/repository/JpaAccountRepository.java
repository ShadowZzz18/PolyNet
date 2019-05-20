package com.polytech.polynet.repository;

import com.polytech.polynet.model.Authority;
import com.polytech.polynet.model.User;

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
    EntityManager AccountEntityManager;

    public JpaAccountRepository(DataSource datasource) {
        this.datasource = datasource;
    }

    @Override
    public List<User> findAllUsers() {
        Query query = AccountEntityManager.createQuery("SELECT s FROM User s");
        return query.getResultList();
    }

    @Override
    public void register(User user) {
        AccountEntityManager.persist(user);
        AccountEntityManager.persist(new Authority(user.getUsername(), 1));
    }

}
