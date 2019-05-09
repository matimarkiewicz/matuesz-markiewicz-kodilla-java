package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simplyUser = new SimpleUser("theForumUser");

        String result = simplyUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        }else{
            System.out.println("Error!");
        }

            System.out.println("\nTest - pierwszy test jednostkowy: \n");

            Calculator Calc = new Calculator();

            int calcResultSub = Calc.substract(3, 5);
            int calcResultAdd = Calc.add(5, 8);

            System.out.println("Wynik odejmowania: " + calcResultSub);
            System.out.println("Wynik dodawania: " + calcResultAdd);
    }
}
