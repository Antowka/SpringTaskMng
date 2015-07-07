package com.antowka.stm.repositories;

import com.antowka.stm.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Anton Nikanorov on 7/8/15.
 * email: 662307@gmail.com
 */
public interface TaskRepository extends CrudRepository<TaskEntity, Long>{


    TaskEntity findById(Long id);

    List<TaskEntity> findByOwner(Integer owner);

    List<TaskEntity> findByName(String name);

}
