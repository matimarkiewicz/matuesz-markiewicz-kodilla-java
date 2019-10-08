package com.kodilla.spring.calculator;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CalculatorTestSuite {
    @Test
    public void testCalculator() {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        double additionResult = calculator.addition(7,9);
        double subtractionResult = calculator.subtraction(5,4);
        double divisionResult = calculator.division(6,6);
        double multiplication = calculator.multiplication(4,3);

        Assert.assertEquals(16,additionResult,0.001);
        Assert.assertEquals(1,subtractionResult,0.001);
        Assert.assertEquals(1, divisionResult,0.001);
        Assert.assertEquals(12, multiplication, 0.001);
    }
}
