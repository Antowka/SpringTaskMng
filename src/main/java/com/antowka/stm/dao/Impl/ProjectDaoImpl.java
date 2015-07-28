package com.antowka.stm.dao.Impl;

import com.antowka.stm.dao.HibernateSessionFactory;
import com.antowka.stm.dao.ProjectDao;
import com.antowka.stm.models.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by anton on 28.07.15.
 */

@Repository
public class ProjectDaoImpl implements ProjectDao {

    @Autowired
    HibernateSessionFactory hibernateSessionFactory;

    @Override
    @Transactional
    public boolean addProject(ProjectEntity project) {
        return false;
    }

    @Override
    @Transactional
    public boolean updateProject(ProjectEntity project) {
        return false;
    }

    @Override
    @Transactional
    public ProjectEntity getProject(long projectId) {
        return null;
    }

    @Override
    @Transactional
    public boolean deleteProject(ProjectEntity project) {
        return false;
    }
}
