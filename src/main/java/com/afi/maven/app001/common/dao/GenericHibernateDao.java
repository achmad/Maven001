/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afi.maven.app001.common.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author AFI
 */
public class GenericHibernateDao <T, K extends Serializable> implements GenericDaoInterface<T, K>{

    @Autowired()
    @Qualifier("SessionFactory")
    private SessionFactory sessionFactory;
    
    private Class <T> persistentClass;
   
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public GenericHibernateDao() {
        persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }    
    
    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public T load(K key) {
        return (T) sessionFactory.getCurrentSession().load(persistentClass, key);
    }

    @Override
    public T get(K key) {
        return (T) sessionFactory.getCurrentSession().get(persistentClass, key);
    }

    @Override
    public void delete(K key) {
        Object entity = getCurrentSession().get(persistentClass, key);
        getCurrentSession().delete(entity);
    }

    @Override
    public void save(T newEntity) {
        getCurrentSession().save(newEntity);
    }

    @Override
    public void evict(Object entity) {
        getCurrentSession().evict(entity);
    }

    @Override
    public void update(T editedEntity) {
        getCurrentSession().update(editedEntity);
    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }

    @Override
    public void clear() {
        getCurrentSession().clear();
    }
    
}
