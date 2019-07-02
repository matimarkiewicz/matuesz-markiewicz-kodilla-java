package com.kodilla.good.patterns.food2door;

import java.util.*;
import java.io.*;
import java.lang.*;

public class SugarProduct extends Product {
    private String sugarType;

    public SugarProduct(String productName, String sugarType) {
        super(productName);
        this.sugarType = sugarType;
    }
}
