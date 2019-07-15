package com.kodilla.patterns.factory.tasks;

import org.junit.Test;
import org.junit.Assert;

public class TaskFactoryTestSuite {
    @Test
    public void testDrivingTask() {

        TaskFactory taskFactory = new TaskFactory();

        Task driving = taskFactory.makeTask(TaskFactory.DRIVING,
                "Driving task", "to go", "yellow car");
        boolean beforeExecution = driving.isTaskExecuted();
        driving.executeTask();

        Assert.assertEquals("Driving task", driving.getTaskName());
        Assert.assertFalse(beforeExecution);
        Assert.assertTrue(driving.isTaskExecuted());
    }

    @Test
    public void testPaintingTask() {

        TaskFactory taskFactory = new TaskFactory();

        Task painting = taskFactory.makeTask(TaskFactory.PAINTING,
                "Painting task", "black", "car");
        boolean beforeExecution = painting.isTaskExecuted();
        painting.executeTask();

        Assert.assertEquals("Painting task", painting.getTaskName());
        Assert.assertFalse(beforeExecution);
        Assert.assertTrue(painting.isTaskExecuted());
    }

    @Test
    public void testShoppingTask() {

        TaskFactory taskFactory = new TaskFactory();

        Task shopping = taskFactory.makeTask(TaskFactory.SHOPPING,
                "Shopping task","lemon","1.5");
        boolean beforeExecution = shopping.isTaskExecuted();
        shopping.executeTask();

        Assert.assertEquals("Shopping task", shopping.getTaskName());
        Assert.assertFalse(beforeExecution);
        Assert.assertTrue(shopping.isTaskExecuted());
    }
}
