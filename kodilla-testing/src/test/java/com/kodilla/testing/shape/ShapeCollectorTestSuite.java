package com.kodilla.testing.shape;

import org.junit.*;
import java.util.*;
import java.lang.*;

public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }
    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }
    @Before
    public void beforeEveryTest() {
        testCounter ++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @Test
    public void testAddFigure(){

        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Circle(35);
        shapeCollector.addFigure(shape);
        Assert.assertEquals(1, shapeCollector.getShapeCollection().size());
    }
    @Test
    public void testRemoveFigure(){

        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Circle(35);
        shapeCollector.addFigure(shape);

        boolean result = shapeCollector.removeFigure(shape);
        Assert.assertTrue(result);
        Assert.assertEquals(0, shapeCollector.getShapeCollection().size());
    }
    @Test
    public void testGetFigureExistNumber(){

        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Circle(35);
        shapeCollector.addFigure(shape);

        Shape shapeResult = shapeCollector.getFigure(0);

        Assert.assertEquals(shape, shapeResult);
    }
    @Test
    public void testShowFigures(){

        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Circle(35);
        shapeCollector.addFigure(shape);
        ArrayList<Shape> shapeList= new ArrayList<>();
        shapeList.add(shape);

        ArrayList<Shape> shapeFullList = shapeCollector.getShapeCollection();

        Assert.assertEquals(shapeList.toString(), shapeFullList.toString());
    }
}
