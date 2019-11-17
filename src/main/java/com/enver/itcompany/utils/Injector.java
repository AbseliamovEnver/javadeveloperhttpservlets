package com.enver.itcompany.utils;

import com.enver.itcompany.dao.*;
import com.enver.itcompany.model.*;
import org.hibernate.SessionFactory;

public class Injector {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private static CustomerDaoImpl customerDao =
            new CustomerDaoImpl(Customer.class.getSimpleName(), sessionFactory, Customer.class);

    private static ProjectDaoImpl projectDao =
            new ProjectDaoImpl(Project.class.getSimpleName(), sessionFactory, Project.class);

    private static SkillDaoImpl skillDao =
            new SkillDaoImpl(Skill.class.getSimpleName(), sessionFactory, Skill.class);

    private static SpecialtyDaoImpl specialtyDao =
            new SpecialtyDaoImpl(Specialty.class.getSimpleName(), sessionFactory, Specialty.class);

    private static TeamDaoImpl teamDao =
            new TeamDaoImpl(Team.class.getSimpleName(), sessionFactory, Team.class);

    private static UserDaoImpl userDao =
            new UserDaoImpl(User.class.getSimpleName(), sessionFactory, User.class);

    private Injector() {
    }
}
