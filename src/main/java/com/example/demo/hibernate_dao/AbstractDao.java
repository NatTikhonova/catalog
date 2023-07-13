package com.example.demo.hibernate_dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public abstract class AbstractDao<T> {
    private final Class<T> cl;
    public AbstractDao(Class<T> cl) {
        this.cl = cl;
    }

    public T getById(int id) {
        return  getOpenSession().get(cl, id);
    }

    public List<T> getAll() {
        try (Session session = getOpenSession()) {
            Query<T> query = session.createQuery("from ".concat(cl.getName()), cl);
            return query.list();
        }
    }

    public void save(T t) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        session.persist(t);
        transaction.commit();
        session.close();
    }

    public void update(T t) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        session.merge(t);
        transaction.commit();
        session.close();
    }

    public void delete(T t) {
        Session session = getOpenSession();
        Transaction transaction = session.beginTransaction();
        session.remove(t);
        transaction.commit();
        session.close();
    }

    protected Session getOpenSession() {
        return SessionFactoryUtil.getSessionFactory().openSession();
    }
}
