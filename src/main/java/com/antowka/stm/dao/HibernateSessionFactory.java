package com.antowka.stm.dao;

import org.hibernate.Session;

/**
 * Created by Anton Nikanorov on 7/11/15.
 * email: 662307@gmail.com
 */
public interface HibernateSessionFactory {

    public Session getSession();
}
