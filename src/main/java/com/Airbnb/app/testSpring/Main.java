package com.Airbnb.app.testSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * Created by romanroma on 01.12.15.
 */
public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ApplicationContext context = new ClassPathXmlApplicationContext("transactionalContext.xml");
        customerDAO customerDAO = context.getBean("customerDAO", customerDAO.class);

        Customer customer = customerDAO.createCustomer(new Customer("Paul"));

        System.out.println("Customer persist : " + customer);

        customer = customerDAO.findCustomer(1);

        System.out.println("Customer find : " + customer);

        customerDAO.deleteCustomer(customer.getId());

        System.out.println("Customer deleted");

    }

}
