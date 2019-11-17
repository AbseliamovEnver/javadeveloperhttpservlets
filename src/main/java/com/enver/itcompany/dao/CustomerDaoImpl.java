package com.enver.itcompany.dao;

import com.enver.itcompany.model.Customer;
import org.hibernate.SessionFactory;

public class CustomerDaoImpl extends AbstractDao<Customer> {
    public CustomerDaoImpl(String className, SessionFactory sessionFactory, Class<Customer> clazz) {
        super(className, sessionFactory, clazz);
    }
}
