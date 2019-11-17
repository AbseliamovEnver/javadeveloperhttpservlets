package com.enver.itcompany.dao;

import com.enver.itcompany.model.Project;
import org.hibernate.SessionFactory;

public class ProjectDaoImpl extends AbstractDao<Project> {
    public ProjectDaoImpl(String className, SessionFactory sessionFactory, Class<Project> clazz) {
        super(className, sessionFactory, clazz);
    }
}
