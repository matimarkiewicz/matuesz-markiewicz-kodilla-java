package com.kodilla.testing.calculator;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Calculator {

    private int a;
    private int b;

    public Calculator (int a, int b) {
        this.a=a;
        this.b=b;
    }
    public int add() {
            return a + b;
    }
    public int substract() {
            return a - b;
    }
}