package com.example.newproject202forfinal.repository;

import com.example.newproject202forfinal.entity.Office;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class OfficeRepository {
    private EntityManager entityManager;

    private EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public List<Office> findAll() {
        return getEntityManager().createNamedQuery("OFFICE.FIND_ALL").getResultList();
    }

    public Office find(String officeCode) {
        return getEntityManager().find(Office.class, officeCode);
    }

    public boolean insert(Office office) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(office);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean delete(String officeCode) {
        EntityManager entityManager = getEntityManager();
        Office office = find(officeCode);
        if (office != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(office);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    public boolean delete(Office office) {
        if (office != null) {
            EntityManager entityManager = getEntityManager();
            if (entityManager.contains(office)) {
                entityManager.getTransaction().begin();
                entityManager.remove(office);
                entityManager.getTransaction().commit();
                return true;
            } else {
                return delete(office.getOfficeCode());
            }
        }
        return false;
    }

    public boolean update(Office newOffice) {
        if (newOffice != null) {
            EntityManager entityManager = getEntityManager();
            Office office = find(newOffice.getOfficeCode());
            if (office != null) {
                entityManager.getTransaction().begin();
                //set all attributes office with newOffice
                if(!newOffice.getCity().isEmpty()){
                    office.setCity(newOffice.getCity());
                }
                if(!newOffice.getPhone().isEmpty()){
                    office.setPhone(newOffice.getPhone());
                }
                if(!newOffice.getAddressLine1().isEmpty()){
                    office.setAddressLine1(newOffice.getAddressLine1());
                }
                if(!newOffice.getAddressLine2().isEmpty()){
                    office.setAddressLine2(newOffice.getAddressLine2());
                }
                if(!newOffice.getState().isEmpty()){
                    office.setState(newOffice.getState());
                }
                if(!newOffice.getCountry().isEmpty()){
                    office.setCountry(newOffice.getCountry());
                }
                if(!newOffice.getPostalCode().isEmpty()){
                    office.setPostalCode(newOffice.getPostalCode());
                }
                if(!newOffice.getTerritory().isEmpty()){
                    office.setTerritory(newOffice.getTerritory());
                }
                //..
                entityManager.getTransaction().commit();
                return true;
            }
        }
        return false;
    }

    public List<Office> findByCityOrCountry(String cityOrCountry) {
        cityOrCountry = cityOrCountry.toLowerCase() + '%';
        Query query = getEntityManager().createNamedQuery("OFFICE.FIND_BY_CITY_OR_COUNTRY");
        query.setParameter("city", cityOrCountry);
        query.setParameter("country", cityOrCountry);
        return query.getResultList();
    }
    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}