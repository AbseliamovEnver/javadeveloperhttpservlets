package com.enver.itcompany.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class AbstractDao<T> implements EntityInterface<T> {
    private static final Logger logger = LogManager.getLogger(AbstractDao.class);
    private String className;
    protected SessionFactory sessionFactory;
    private Class<T> clazz;

    public AbstractDao(String className, SessionFactory sessionFactory, Class<T> clazz) {
        this.className = className;
        this.sessionFactory = sessionFactory;
        this.clazz = clazz;
    }

    @Override
    public void add(T entity) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.save(entity);
                session.getTransaction().commit();
                logger.info("Entity successfully added.");
            } catch (HibernateException e) {
                session.getTransaction().rollback();
                logger.error("Error adding entity. ", e);
            }
        }
    }

    @Override
    public void update(T entity) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                if (entity != null) {
                    session.update(entity);
                }
                session.getTransaction().commit();
                logger.info("Entity successfully updated.");
            } catch (HibernateException e) {
                session.getTransaction().rollback();
                logger.error("Error updating entity. ", e);
            }
        }
    }

    @Override
    public void remove(long id) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                T entity = getById(id);
                session.delete(entity);
                session.getTransaction().commit();
                logger.info("Entity successfully removed.");
            } catch (HibernateException e) {
                session.getTransaction().rollback();
                logger.error("Error removing entity. ", e);
            }
        }
    }

    @Override
    public T getById(long id) {
        T entity = null;
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                entity = session.get(clazz, id);
                session.getTransaction().commit();
                logger.info("Entity by ID received successfully.");
            } catch (HibernateException e) {
                session.getTransaction().rollback();
                logger.error("Error getting entity by ID. ", e);
            }
        }
        return entity;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        List<T> entities = null;
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                entities = session.createQuery("from " + className).list();
                session.getTransaction().commit();
                logger.info("All entities received successfully.");
            } catch (HibernateException e) {
                session.getTransaction().rollback();
                logger.error("Error getting all entity. ", e);
            }
        }
        return entities;
    }
}
