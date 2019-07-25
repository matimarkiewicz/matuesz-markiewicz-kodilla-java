package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TaskListDaoTestSuite {

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

       // taskListDao.delete(taskListFirst);
       // taskListDao.delete(taskListSecond);
       // taskListDao.delete(taskListThird);
    }
}
