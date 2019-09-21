package entity;

import entity.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-21T16:03:15")
@StaticMetamodel(OrderM.class)
public class OrderM_ { 

    public static volatile SingularAttribute<OrderM, Integer> orderID;
    public static volatile SingularAttribute<OrderM, Integer> id;
    public static volatile SingularAttribute<OrderM, Customer> customer;

}