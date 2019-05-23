package com.kodilla.stream;

import java.lang.*;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {

    public static void main(String[] args) {

        //ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        //System.out.println("Calculating expressions with lambdas");

        //expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        //expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        //expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        //expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        //System.out.println("Calculating expressions with method references");

        //expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        //expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        //expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        //expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        String beautifulText01 = poemBeautifier.beautify("Text to beautify", (String::toUpperCase));
        System.out.println(beautifulText01);

        String beautifulText02 = poemBeautifier.beautify("Text to beautify", (text -> "ABC - " + text + " - ABC"));
        System.out.println(beautifulText02);

        String beautifulText03 = poemBeautifier.beautify("Text to beautify", (text -> text.replace(" ", "_")));
        System.out.println(beautifulText03);

        String beautifulText04 = poemBeautifier.beautify("Text to beautify", (text ->  "*" + text + "* has got " + text.length() + " letters."));
        System.out.println(beautifulText04);
    }
}
