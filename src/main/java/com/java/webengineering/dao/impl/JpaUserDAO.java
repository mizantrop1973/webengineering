package com.java.webengineering.dao.impl;

import com.java.webengineering.dao.UserDAO;
import com.java.webengineering.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class JpaUserDAO implements UserDAO {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return entityManager.createQuery("select u from User u", User.class
        ).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public User getOne(String email) {
        TypedQuery<User> q = entityManager.createQuery(
                "select u from User u where u.email= :email", User.class
        );
        q.setParameter("email", email);
        return q.getResultList().stream().findAny().orElse(null);
    }

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }
}
