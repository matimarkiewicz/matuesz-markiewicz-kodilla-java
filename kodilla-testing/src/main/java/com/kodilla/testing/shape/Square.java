package com.kodilla.testing.shape;

import java.util.*;
import java.lang.*;

public class Square implements Shape {

    private String name = "Square";
    private double length;

    public Square(double length) {
        this.length = length;
    }
    public String getShapeName() {
        return name;
    }
    public double getField() {
        return Math.pow(length, 2);
    }
}
