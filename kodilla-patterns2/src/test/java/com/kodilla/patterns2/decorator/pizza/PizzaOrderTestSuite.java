package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost() {

        PizzaOrder theOrder = new BasicPizzaOrder();

        BigDecimal theCost = theOrder.getCost();

        assertEquals(new BigDecimal(25), theCost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {

        PizzaOrder theOrder = new BasicPizzaOrder();

        String description = theOrder.getDescription();

        assertEquals("You order a pizza", description);
    }

    @Test
    public void testBasicPizzaOrderDoubleCheeseHamGetCost() {

        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new DoubleCheeseDecorator(theOrder);
        theOrder = new HamDecorator(theOrder);

        BigDecimal theCost = theOrder.getCost();

        assertEquals(new BigDecimal(32.5), theCost);
    }

    @Test
    public void testBasicPizzaOrderDoubleCheeseHamGetDescription() {

        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new DoubleCheeseDecorator(theOrder);
        theOrder = new HamDecorator(theOrder);

        String description = theOrder.getDescription();

        assertEquals("You order a pizza" + " with double cheese" + " with ham", description);
    }
}
