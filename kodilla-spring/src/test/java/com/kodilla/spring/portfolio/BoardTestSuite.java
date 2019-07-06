package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class BoardTestSuite {
    @Test
    public void testTaskAdd() {

        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        String nextTaskToDo = "to do";
        String nextTaskInProgress = "in progress";
        String nextTaskDone = "done";
        board.getToDoList().addTask(nextTaskToDo);
        board.getInProgressList().addTask(nextTaskInProgress);
        board.getDoneList().addTask(nextTaskDone);

        Assert.assertEquals("to do", board.getToDoList().getTasks().get(0));
        Assert.assertEquals("in progress", board.getInProgressList().getTasks().get(0));
        Assert.assertEquals("done", board.getDoneList().getTasks().get(0));
    }
}
