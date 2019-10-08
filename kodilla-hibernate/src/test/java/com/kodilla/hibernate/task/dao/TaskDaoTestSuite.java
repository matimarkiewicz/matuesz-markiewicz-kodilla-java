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

        taskListDao.deleteById(id);
    }

    @Test
    public void testNamedQueries() {

        Task task1 = new Task("Test: Study Hibernate", 3);
        Task task2 = new Task("Test: Practice Named Queries", 6);
        Task task3 = new Task("Test: Study native queries", 7);
        Task task4 = new Task("Test: Makse some tests", 13);

        TaskFinancialDetails tfd1 = new TaskFinancialDetails(new BigDecimal(5), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        TaskFinancialDetails tfd3 = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd4 = new TaskFinancialDetails(new BigDecimal(15), false);

        task1.setTaskFinancialDetails(tfd1);
        task2.setTaskFinancialDetails(tfd2);
        task3.setTaskFinancialDetails(tfd3);
        task4.setTaskFinancialDetails(tfd4);

        TaskList taskList = new TaskList(LISTNAME, "ToDo tasks");
        taskList.getTasks().add(task1);
        taskList.getTasks().add(task2);
        taskList.getTasks().add(task3);
        taskList.getTasks().add(task4);

        task1.setTaskList(taskList);
        task2.setTaskList(taskList);
        task3.setTaskList(taskList);
        task4.setTaskList(taskList);

        taskListDao.save(taskList);
        long id = taskList.getId();

        List<Task> longTasks = taskDao.retrieveLongTasks();
        List<Task> shortTasks = taskDao.retrieveShortTasks();
        List<Task> enoughTimeTasks = taskDao.retrieveTasksWithEnoughTime();
        List<Task> durationLongerThanTasks = taskDao.retrieveTasksWithDurationLongerThan(6);

        try {
            Assert.assertEquals(1, longTasks.size());
            Assert.assertEquals(3, shortTasks.size());
            Assert.assertEquals(3, enoughTimeTasks.size());
            Assert.assertEquals(2, durationLongerThanTasks.size());
        } finally {

            taskListDao.deleteById(id);
        }
    }
}