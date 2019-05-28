package com.kodilla.stream.array;

import org.junit.*;
import java.util.*;
import java.lang.*;
import java.io.*;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {

        int numbers[] = {2, 10, 14, 16, 23, 11, 4, 3, 12, 2, 12, 11, 3, 8, 7, 12, 2, 7, 6, 8};

        double average = ArrayOperations.getAverage(numbers);

        Assert.assertEquals(8.65, average, 0.001);
    }
}