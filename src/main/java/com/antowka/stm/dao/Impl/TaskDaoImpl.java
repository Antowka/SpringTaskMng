package com.antowka.stm.dao.Impl;

import com.antowka.stm.dao.HibernateSessionFactory;
import com.antowka.stm.dao.TaskDao;
import com.antowka.stm.models.TaskEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Anton Nikanorov on 7/11/15.
 * email: 662307@gmail.com
 */
@Repository
public class TaskDaoImpl implements TaskDao{

    @Autowired
    HibernateSessionFactory hibernateSessionFactory;


    @Override
    @Transactional
    public boolean addTask(TaskEntity task) {
        Session session = hibernateSessionFactory.getSession();
        session.save(task);
        return true;
    }

    @Override
    @Transactional
    public boolean updateTask(TaskEntity task) {
        Session session = hibernateSessionFactory.getSession();
        session.update(task);
        return true;
    }

    @Override
    @Transactional
    public TaskEntity getTask(long taskId) {

        TaskEntity taskEntity = null;
        try {
            Session session = hibernateSessionFactory.getSession();
            taskEntity = (TaskEntity) session.get(TaskEntity.class, taskId);
        } catch (RuntimeException e){
            String test ="0";
        }


        return taskEntity;
    }

    @Override
    @Transactional
    public boolean deleteTask(TaskEntity task) {
        Session session = hibernateSessionFactory.getSession();
        session.delete(task);
        return true;
    }
}
