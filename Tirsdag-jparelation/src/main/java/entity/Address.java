/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author artin
 */
public class Address implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String street;
       private String city;
    
    @ManyToMany(mappedBy = "addresses", cascade =
        {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Customer> customers = new ArrayList();
    
//    @ManyToOne
//    private Customer customer;
    
//    @OneToOne(mappedBy = "address")
//    private Customer customer;

    public Address()
    {
    }

    public Address(String street, String city)
    {
        this.street = street;
        this.city = city;
    }

    public List<Customer> getCustomers()
    {
        return customers;
    }

    public void addCustomer(Customer customer)
    {
        customers.add(customer);
    }

    

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
 @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address))
        {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entity.Address[ id=" + id + " ]";
    }

}
