package com.antowka.stm.dao.Impl;

import com.antowka.stm.dao.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Anton Nikanorov on 7/11/15.
 * email: 662307@gmail.com
 */
public class HibernateSessionFactoryImpl implements HibernateSessionFactory{

    private SessionFactory sessionFactory;

    @Override
    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
