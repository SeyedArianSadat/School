package com.school.model.repository;

import com.school.model.common.JpaProvider;
import com.school.model.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class TeacherRepository {
    public void save(Teacher teacher) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(teacher);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("failed to save teacher", e);
        } finally {
            entityManager.close();
        }
    }

    public void update(Teacher teacher) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(teacher);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("failed to update teacher", e);
        } finally {
            entityManager.close();
        }
    }

    public void deleteById(Long id) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Teacher teacher = entityManager.find(Teacher.class, id);
            entityManager.remove(teacher);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("failed to delete teacher", e);
        } finally {
            entityManager.close();
        }
    }

    public Optional<Teacher> findById(Long id) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        try {
            Teacher teacher = entityManager.find(Teacher.class, id);
            return Optional.ofNullable(teacher);
        } finally {
            entityManager.close();
        }
    }
    public List<Teacher> findAll() {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        try {
            String jpql = "select teacher from teacherEntity teacher";
            TypedQuery<Teacher> query = entityManager.createQuery(jpql, Teacher.class);
            return query.getResultList();
        }finally {
            entityManager.close();
        }
    }
}
