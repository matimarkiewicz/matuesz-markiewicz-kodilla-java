package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import com.kodilla.hibernate.tasklist.dao.TaskListDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.lang.*;
import java.util.Properties;

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

    @Test
    public void testTaskDaoSaveWithFinancialDetails() {

        Task task = new Task(DESCRIPTION, 30);
        task.setTaskFinancialDetails(new TaskFinancialDetails(new BigDecimal(120), false));

        taskDao.save(task);
        long id = task.getId();

        Assert.assertNotEquals(0, id);

        taskDao.delete(id);
    }

    @Autowired
    private TaskListDao taskListDao;

    private static final String LISTNAME = "Sprzatanie";
    private static final String DESCRIPTION_FIRST = "PRANIE";
    private static final String DESCRIPTION_SECOND = "MYCIE";
    private static final String DESCRIPTION_THIRD = "ZAMIATANIE";

    @Test
    public void findByListName() {

        TaskList taskListFirst = new TaskList(LISTNAME, DESCRIPTION_FIRST);
        TaskList taskListSecond = new TaskList(LISTNAME, DESCRIPTION_SECOND);
        TaskList taskListThird = new TaskList(LISTNAME, DESCRIPTION_THIRD);

        taskListDao.save(taskListFirst);
        taskListDao.save(taskListSecond);
        taskListDao.save(taskListThird);

        List<TaskList> readTaskList = taskListDao.findByListName(LISTNAME);

        Assert.assertEquals(3, readTaskList.size());
        Assert.assertEquals(LISTNAME, readTaskList.get(0).getListName());
        Assert.assertEquals(LISTNAME, readTaskList.get(1).getListName());
        Assert.assertEquals(LISTNAME, readTaskList.get(2).getListName());

        taskListDao.delete(taskListFirst);
        taskListDao.delete(taskListSecond);
        taskListDao.delete(taskListThird);
    }

    @Test
    public void testTaskListDaoSaveWithTasks() {

        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList(LISTNAME, "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        taskListDao.save(taskList);
        long id = taskList.getId();

        Assert.assertNotEquals(0, id);

        //taskListDao.delete(id);
    }
}