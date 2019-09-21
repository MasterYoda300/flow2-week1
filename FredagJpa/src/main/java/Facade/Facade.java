
package Facade;

import entity.Customer;
import entity.ItemType;
import entity.OrderM;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class Facade {

    private static Facade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private Facade()
    {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static Facade getFacade(EntityManagerFactory _emf)
    {
        if (instance == null)
        {
            emf = _emf;
            instance = new Facade();
        }
        return instance;
    }

    private EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    public List<Customer> getAllCustomers()
    {
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Customer.getAll").getResultList();
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

    public Customer addCustomer(String email, String name)
    {
        Customer customer = new Customer(email, name);
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

    public Customer getCustomerByName(String name) throws Exception
    {
        EntityManager em = getEntityManager();
        try
        {
            return em.createQuery("SELECT m FROM Customer m WHERE m.name = :name", Customer.class).getSingleResult();
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new Exception("Non found by that name");
        } finally
        {
            em.close();
        }

    }

    public Customer getCustomerById(long id)
    {
        EntityManager em = getEntityManager();
        try
        {
            return (Customer) em.createQuery("SELECT m FROM Customer m WHERE m.id =:id").setParameter("id", id).getSingleResult();
        } finally
        {
            em.close();
        }

    }

    
    public List<ItemType> getAllItemTypes()
    {
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("ItemType.getAll").getResultList();
    }

    public ItemType addItemType(ItemType item)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(item);
            em.getTransaction().commit();
            return item;
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            em.close();
        }
        return item;
    }

    public ItemType addItemType(String name, String description, int price)
    {
        ItemType item = new ItemType(name, description, price);
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(item);
            em.getTransaction().commit();
            return item;
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            em.close();
        }
        return item;
    }

    public OrderM addOrder(int id)
    {
        OrderM order = new OrderM();
        EntityManager em = emf.createEntityManager();
        Customer cust = getCustomerById(id);
        order.setCustomer(cust);
        try
        {
            em.getTransaction().begin();
            em.persist(order);
            em.getTransaction().commit();
            return order;
        } finally
        {
            em.close();
        }

    }

    public ItemType getItemTypeByName(String name) throws Exception
    {
        EntityManager em = getEntityManager();
        try
        {
            return em.createQuery("SELECT m FROM  ItemType m WHERE m.name =: name", ItemType.class).setParameter("name", name).getSingleResult();
        } catch (Exception e)
        {
            throw new Exception("Non found by that name");
        } finally
        {
            em.close();
        }

    }

  

}