package com.kodilla.testing.shape;

import java.util.*;
import java.lang.*;

public class Circle implements Shape {

    private String name = "Circle";
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    public String getShapeName() {
        return name;
    }
    public double getField() {
        return Math.PI * Math.pow(radius, 2);
    }
}
