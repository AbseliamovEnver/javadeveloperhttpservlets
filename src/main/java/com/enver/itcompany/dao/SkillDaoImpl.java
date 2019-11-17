package com.enver.itcompany.dao;

import com.enver.itcompany.model.Skill;
import org.hibernate.SessionFactory;

public class SkillDaoImpl extends AbstractDao<Skill> {
    public SkillDaoImpl(String className, SessionFactory sessionFactory, Class<Skill> clazz) {
        super(className, sessionFactory, clazz);
    }
}
