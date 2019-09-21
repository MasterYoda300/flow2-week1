/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author artin
 */
public class CustomerFacade {
    
    private static CustomerFacade instance;
    private static EntityManagerFactory emf;
    
    public CustomerFacade()
    {
    }
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Customer getCustomer(int id)
    {
        EntityManager em = getEntityManager();
        Long ID = Long.parseLong("" + id);
        try
        {
            Customer customer = em.find(Customer.class, ID);
            return customer;
        
        }finally
        {
            em.close();
        }
    }
    
    
    public List<Customer> getCustomers()
    {
        EntityManager em = getEntityManager();
        try
        {
            TypedQuery<Customer> query
                    = em.createQuery("SELECT c FROM Customer c", Customer.class);
            return query.getResultList();
        
        } finally
        {
            em.close();
        }
    }
    
   public Customer addCustomer(Customer customer)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            return customer;
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            em.close();
        }
        return customer;
    }
    
    public Customer deleteCustomer(int id)
    {
        EntityManager em = getEntityManager();
        Long ID = Long.parseLong("" + id);
        try
        {
            em.getTransaction().begin();
            Customer target = em.find(Customer.class, ID);
            em.remove(target);
            em.getTransaction().commit();
            return target;
        
        } finally
        {
            em.close();
        }
    }
    
    
    public Customer editCustomer(Customer customer)
    {
        
        EntityManager em = getEntityManager();
        try
        {
            em.getTransaction().begin();
            em.merge(customer);
            em.getTransaction().commit();
            return customer;
        
        } finally
        {
            em.close();
        }
    }
    
}
