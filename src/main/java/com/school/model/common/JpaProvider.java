package com.school.model.common;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Slf4j
public class JpaProvider {
    @Getter
    private final static JpaProvider instance = new JpaProvider();
    private final EntityManagerFactory factory;

    private JpaProvider() {
        try {

            log.info("Creating EntityManagerFactory");
            factory = Persistence.createEntityManagerFactory("schoolPU");
            log.info("Created EntityManager");
        } catch (Exception e) {
            log.error("failed to initialize EntityManagerFactory", e);
            throw new RuntimeException("failed to initialize EntityManagerFactory", e);
        }
    }

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public void close() {
        log.info("Closing EntityManagerFactory");
        factory.close();
        log.info("Closed EntityManager");

    }
}