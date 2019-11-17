package com.enver.itcompany.dao;

import com.enver.itcompany.model.Team;
import org.hibernate.SessionFactory;

public class TeamDaoImpl extends AbstractDao<Team> {
    public TeamDaoImpl(String className, SessionFactory sessionFactory, Class<Team> clazz) {
        super(className, sessionFactory, clazz);
    }
}
