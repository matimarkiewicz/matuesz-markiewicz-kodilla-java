package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.*;
import java.util.*;

public class CollectionTestSuite {
    @Test
    public void testOddNumbersExterminatorEmptyList(){

        OddNumbersExterminator oddNumbers = new OddNumbersExterminator();

        ArrayList<Integer> emptyArrayList = new ArrayList<>();

        ArrayList<Integer> fullArrayList = oddNumbers.exterminate(emptyArrayList);
        System.out.println("Testing emptyArrayList...");

        Assert.assertEquals(emptyArrayList, fullArrayList);
    }
    @Test
    public void testOddNumbersExterminatorNormalList(){

        OddNumbersExterminator oddNumbers = new OddNumbersExterminator();

        ArrayList<Integer> normalArrayList = new ArrayList<>();
        normalArrayList.add(0);
        normalArrayList.add(1);
        normalArrayList.add(2);
        normalArrayList.add(3);

        ArrayList<Integer> expectedArrayList = new ArrayList<>();
        expectedArrayList.add(0);
        expectedArrayList.add(2);

        ArrayList<Integer> fullArrayList = oddNumbers.exterminate(normalArrayList);
        System.out.println("Testing normalArrayList...");

        Assert.assertEquals(expectedArrayList, fullArrayList);
    }
    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: end");
    }
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Test Suite: begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }
}
