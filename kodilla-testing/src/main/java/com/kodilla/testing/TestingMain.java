package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simplyUser = new SimpleUser("theForumUser");

        String result = simplyUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("\nTest - pierwszy test jednostkowy: \n");

        Calculator calc = new Calculator(2, 4);

        int add = calc.add();
        int substract = calc.substract();

        System.out.println("Wynik odejmowania: " + add);
        System.out.println("Wynik dodawania: " + substract);
    }
}
