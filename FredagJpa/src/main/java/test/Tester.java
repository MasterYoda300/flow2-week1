/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Facade.Facade;
import entity.Customer;
import entity.ItemType;
import entity.OrderM;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author artin
 */
public class Tester {
    
    
    public static void main(String[] args) {
        
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        Facade facade = Facade.getFacade(emf);
        Customer cust = new Customer("alien","iwanttobelieve@hotmail.dk");
        Customer c1 = facade.addCustomer(cust);
        System.out.println(c1.getId());
        Customer c2 = facade.addCustomer( "alien","killer@hotmail.dk");
        System.out.println(c2.getName());
        ItemType glaive = facade.addItemType("doomSlayer", "demon...", 9001);
        System.out.println(glaive.getId());
        System.out.println(facade.getAllCustomers());
        Customer cus = facade.getCustomerById(1);
        System.out.println(cus.getName());
        OrderM order = facade.addOrder(1);
    }
}
