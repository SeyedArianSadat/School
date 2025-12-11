package com.school.model.repository;

import com.school.model.entity.Student;
import com.school.model.common.JpaProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class StudentRepository {
    public void save(Student student) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("failed to save", e);
        } finally {
            entityManager.close();
        }
    }

    public void update(Student student) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("failed to update", e);
        } finally {
            entityManager.close();
        }
    }

    public void deleteById(Long id) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Student student = entityManager.find(Student.class, id);
            entityManager.remove(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("failed to delete", e);
        } finally {
            entityManager.close();
        }
    }

    public Optional<Student> findById(Long id) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        try {
            Student student = entityManager.find(Student.class, id);
            return Optional.ofNullable(student);
        } finally {
            entityManager.close();
        }
    }

    public List<Student> findAll() {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        try {
            String jpql = "select s from studentEntity s  ";
            TypedQuery<Student> query = entityManager.createQuery(jpql, Student.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
}

