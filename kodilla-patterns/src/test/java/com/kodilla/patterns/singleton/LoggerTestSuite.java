package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLogTest() {

        String firstLog = "Log number 1.";
        String secondLog = "Log number 2.";
        String thirdLog = "Log number 3.";

        Logger.getInstance().log(firstLog);
        Logger.getInstance().log(secondLog);
        Logger.getInstance().log(thirdLog);

        Assert.assertEquals(thirdLog, Logger.getInstance().getLastLog());
    }
}
