package com.school.model.repository;

import com.school.model.entity.User;
import com.school.model.common.JpaProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    public void save(User user) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error saving user", e);
        } finally {
            entityManager.close();
        }
    }

    public void update(User user) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error updating user", e);
        } finally {
            entityManager.close();
        }
    }

    public void deleteById(Long id) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            User user = entityManager.find(User.class, id);
            entityManager.remove(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error deleting user", e);
        } finally {
            entityManager.close();
        }
    }

    public Optional<User> findById(Long id) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        try {
            User user = entityManager.find(User.class, id);
            return Optional.ofNullable(user);
        } finally {
            entityManager.close();
        }
    }
    public Optional<User> findByUsername(String username) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        try {
            User user = entityManager.find(User.class, username);
            return Optional.ofNullable(user);
        }finally {
            entityManager.close();
        }
    }

    public List<User> findAll() {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        try {
            String jpql = "select u from userEntity u";
            TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
}

