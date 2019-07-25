package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface TaskDao extends CrudRepository<Task, Long> {
    List<Task> findByDuration(long duration);

    Optional<Task> findById(long id);
}
