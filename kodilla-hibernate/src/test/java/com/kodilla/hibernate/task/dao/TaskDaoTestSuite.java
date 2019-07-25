package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.lang.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TaskDaoTestSuite {
    @Autowired
    private TaskDao taskDao;
    private static final String DESCRIPTION = "Test: Learn Hibernate";

    @Test
    public void testTaskDaoSave() {

        Task task = new Task(DESCRIPTION, 7);
        taskDao.save(task);
        long id = task.getId();

        Optional<Task> readTask = taskDao.findById(id);
        Assert.assertTrue(readTask.isPresent());
    }

    @Test
    public void testTaskDaoFindByDuration() {

        Task task = new Task(DESCRIPTION, 7);
        taskDao.save(task);
        long duration = task.getDuration();

        List<Task> readTasks = taskDao.findByDuration(duration);

        Assert.assertEquals(1, readTasks.size());
        long id = readTasks.get(0).getId();

        taskDao.delete(id);
    }
}