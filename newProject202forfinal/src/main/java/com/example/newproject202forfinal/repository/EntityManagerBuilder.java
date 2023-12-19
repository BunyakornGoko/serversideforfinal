package com.example.newproject202forfinal.repository;

import com.example.newproject202forfinal.entity.Environment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerBuilder {
    private final static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory(Environment.PUNIT_NAME);

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
