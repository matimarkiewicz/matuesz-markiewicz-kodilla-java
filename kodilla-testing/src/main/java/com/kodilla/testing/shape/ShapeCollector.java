package com.kodilla.testing.shape;

import java.util.*;
import java.lang.*;

public class ShapeCollector {

    private ArrayList<Shape> shapeCollection = new ArrayList<>();

    public ArrayList<Shape> getShapeCollection() {
        return shapeCollection;
    }
    public boolean addFigure(Shape shape){
        return shapeCollection.add(shape);
    }
    public boolean removeFigure(Shape shape){
        return shapeCollection.remove(shape);
    }
    public Shape getFigure(int n){
        if(n < shapeCollection.size() && n > -1){
            return shapeCollection.get(n);
        } else {
            return null;
        }
    }
    public void showFigures(){
        System.out.println(shapeCollection.toString());
    }
}

