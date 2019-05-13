package com.kodilla.testing.collection;

import java.lang.*;
import java.io.*;
import java.util.*;

public class OddNumbersExterminator{

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers){

        ArrayList<Integer> even = new ArrayList<>();

        for (int value: numbers){
            if (value % 2 == 0){
                even.add(value);
            }
        }
        return even;
    }
}