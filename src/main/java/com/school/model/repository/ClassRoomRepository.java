package com.school.model.repository;

import com.school.model.entity.ClassRoom;
import com.school.model.common.JpaProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class ClassRoomRepository {
    public void save(ClassRoom classRoom) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(classRoom);
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

    public void update(ClassRoom classRoom) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(classRoom);
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
            ClassRoom classRoom = entityManager.find(ClassRoom.class, id);
            entityManager.remove(classRoom);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("failed to delete,e");
        } finally {
            entityManager.close();
        }
    }

    public Optional<ClassRoom> findById(Long id) {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        try {
            ClassRoom classRoom = entityManager.find(ClassRoom.class, id);
            return Optional.ofNullable(classRoom);
        } finally {
            entityManager.close();
        }
    }

    public List<ClassRoom> findAll() {
        EntityManager entityManager = JpaProvider.getInstance().getEntityManager();
        try {
            String jpql = "select c from classroomEntity c";
            TypedQuery<ClassRoom> query = entityManager.createQuery(jpql, ClassRoom.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
}


