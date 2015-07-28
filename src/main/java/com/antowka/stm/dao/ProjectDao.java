package com.antowka.stm.dao;

import com.antowka.stm.models.ProjectEntity;
import com.antowka.stm.models.TaskEntity;

/**
 * Created by anton on 28.07.15.
 */
public interface ProjectDao {

    public boolean addProject(ProjectEntity project);
    public boolean updateProject(ProjectEntity project);
    public ProjectEntity getProject(long projectId);
    public boolean deleteProject(ProjectEntity project);
}
