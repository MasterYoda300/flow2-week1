/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(
{
    @NamedQuery(name = "Customer.deleteAllRows", query = "DELETE from Customer"),
    @NamedQuery(name = "Customer.getAll", query = "SELECT r from Customer r")
})

public class Customer implements Serializable {

    @OneToMany (mappedBy = "customer")
    private List<OrderM> orders = new ArrayList();

    public List<OrderM> getOrders()
    {
        return orders;
    }

    public void setOrders(OrderM order)
    {
        this.orders.add(order);
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Customer(String email, String name)
    {
        this.email = email;
        this.name = name;
    }

    public Customer()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

}