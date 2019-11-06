package com.kodilla.patterns2.aop.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;
    private static final Logger LOGGER =
            LoggerFactory.getLogger(CalculatorTestSuite.class);

    @Test
    public void testAdd() {

        double result = calculator.add(10, 15);

        LOGGER.info("Testing add method");
        assertEquals(25, result, 0);
    }
    @Test
    public void testSub() {

        double result = calculator.sub(10, 15);

        LOGGER.info("Testing sub method");
        assertEquals(-5, result, 0);
    }
    @Test
    public void testMul() {

        double result = calculator.mul(10, 15);
        //Then
        LOGGER.info("Testing mul method");
        assertEquals(150, result, 0);
    }
    @Test
    public void testDiv() {

        double result = calculator.div(15, 5);

        LOGGER.info("Testing div method");
        assertEquals(3, result, 0);
    }

    @Test
    public void testFactorial() {

        BigDecimal result = calculator.factorial(new BigDecimal("3"));

        LOGGER.info("Testing factorial method");
        System.out.println(result);
        assertTrue(BigDecimal.ONE.compareTo(result) < 0);
    }
}