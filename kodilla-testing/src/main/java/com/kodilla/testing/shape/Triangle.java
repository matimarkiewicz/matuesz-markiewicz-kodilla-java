package com.kodilla.testing.shape;

import java.util.*;
import java.lang.*;

public abstract class Triangle implements Shape {

    private String name = "Triangle";
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public String getShapeName() {
        return name;
    }
    private double getHalfCircum(){
        return (a + b + c)/2;
    }
    public double getField(double halfCircum) {
        return Math.sqrt(halfCircum*(halfCircum-a)*(halfCircum-b)*(halfCircum-c));
    }
}
