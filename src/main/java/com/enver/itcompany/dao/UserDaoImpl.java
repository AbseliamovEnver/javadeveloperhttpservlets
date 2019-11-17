package com.enver.itcompany.dao;

import com.enver.itcompany.model.User;
import org.hibernate.SessionFactory;

public class UserDaoImpl extends AbstractDao<User> {
    public UserDaoImpl(String className, SessionFactory sessionFactory, Class<User> clazz) {
        super(className, sessionFactory, clazz);
    }
}
