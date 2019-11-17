package com.enver.itcompany.dao;

import com.enver.itcompany.model.Specialty;
import org.hibernate.SessionFactory;

public class SpecialtyDaoImpl extends AbstractDao<Specialty> {
    public SpecialtyDaoImpl(String className, SessionFactory sessionFactory, Class<Specialty> clazz) {
        super(className, sessionFactory, clazz);
    }
}
