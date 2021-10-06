package com.khodko.forestry.dao;

import com.khodko.forestry.entity.BaseEntity;
import com.khodko.forestry.session.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class BaseDao<T extends BaseEntity> {

    private final Class<T> persistentClass;

    public BaseDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected void executeConsume(Consumer<Session> consumer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        consumer.accept(session);
        tx1.commit();
        session.close();
    }

    protected <R> R executeFunction(Function<Session, R> function) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        R result = function.apply(session);
        tx1.commit();
        session.close();
        return result;
    }

    public Serializable save(T item) {
        return executeFunction(session -> session.save(item));
    }

    public void update(T item) {
        executeConsume(session -> session.update(item));
    }

    public void delete(T item) {
        executeConsume(session -> session.delete(item));
    }

    public T findById(long id) {
        return executeFunction(session -> session.find(persistentClass, id));
    }

    public List<T> findAll() {
        return executeFunction(session -> {
            String hql = String.format("SELECT a FROM %s a", persistentClass.getSimpleName());
            return session.createQuery(hql, persistentClass).getResultList();
        });
    }

}
