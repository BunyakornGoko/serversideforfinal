package com.example.newproject202forfinal.repository;

import com.example.newproject202forfinal.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class CustomerRepository {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public Customer findByName(String name) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("CUSTOMER.FIND_USER");
        query.setParameter("user_account", name);
        return (Customer) query.getSingleResult();
    }

    public List<Customer> findAll() {
        return getEntityManager().createQuery("select c from Customer c").getResultList();
    }
}