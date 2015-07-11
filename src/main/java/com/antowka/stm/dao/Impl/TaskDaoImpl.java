package com.antowka.stm.dao.Impl;

import com.antowka.stm.dao.HibernateSessionFactory;
import com.antowka.stm.dao.TaskDao;
import com.antowka.stm.models.TaskEntity;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Anton Nikanorov on 7/11/15.
 * email: 662307@gmail.com
 */
@Repository
public class TaskDaoImpl implements TaskDao{

    @Autowired
    HibernateSessionFactory hibernateSessionFactory;

    @Override
    public boolean addTask(TaskEntity task) {
        Session session = hibernateSessionFactory.getSession();
        session.save(task);
        return true;
    }

    @Override
    public boolean updateTask(TaskEntity task) {
        Session session = hibernateSessionFactory.getSession();
        session.update(task);
        return true;
    }

    @Override
    public TaskEntity getTask(long taskId) {

        TaskEntity taskEntity = null;

        Session session = hibernateSessionFactory.getSession();
        taskEntity = (TaskEntity) session.createCriteria(TaskEntity.class)
                .add(Restrictions.eq("taskId", taskId))
                .uniqueResult();

        return taskEntity;
    }

    @Override
    public boolean deleteTask(TaskEntity task) {
        Session session = hibernateSessionFactory.getSession();
        session.delete(task);
        return true;
    }
}
