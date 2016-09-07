package com.Airbnb.app.testSpring;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by romanroma on 01.12.15.
 */
public class customerDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Customer createCustomer (Customer customer){
        em.persist(customer);
        return customer;
    }

    @Transactional
    public void deleteCustomer (Integer id){
        Customer customer = em.find(Customer.class, id);
        if (customer != null){
            em.remove(customer);
        }
    }

    public Customer findCustomer (Integer id){
        return em.find(Customer.class,id);
    }

}
