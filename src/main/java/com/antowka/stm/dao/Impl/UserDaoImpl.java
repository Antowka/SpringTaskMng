package com.antowka.stm.dao.Impl;

import com.antowka.stm.dao.HibernateSessionFactory;
import com.antowka.stm.dao.UserDao;
import com.antowka.stm.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Anton Nik on 28.07.15.
 */

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    HibernateSessionFactory hibernateSessionFactory;

    @Override
    @Transactional
    public boolean addTask(UserEntity user) {
        return false;
    }

    @Override
    @Transactional
    public boolean updateTask(UserEntity user) {
        return false;
    }

    @Override
    @Transactional
    public UserEntity getTask(long userId) {
        return null;
    }

    @Override
    @Transactional
    public boolean deleteTask(UserEntity user) {
        return false;
    }
}
