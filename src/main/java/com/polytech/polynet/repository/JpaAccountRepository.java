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

    @Override
    public boolean login(String username, String password) {
        return !AccountEntityManager.createQuery("SELECT s FROM User s WHERE s.username = :username AND s.password = :password")
                            .setParameter("username", username)
                            .setParameter("password", password)
                            .getResultList().isEmpty();
    }

    @Override
    public User findByUsername(String username) {
        User user = AccountEntityManager.find(User.class, username);
        return user;
    }

}
