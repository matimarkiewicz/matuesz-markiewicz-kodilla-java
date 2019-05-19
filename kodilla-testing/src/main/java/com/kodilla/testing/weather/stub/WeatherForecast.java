package com.kodilla.testing.weather.stub;

import java.util.*;
import java.lang.*;
import java.io.*;

public class WeatherForecast {
    Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }
    public HashMap<Integer, Double> calculateForecast() {
        HashMap<Integer, Double> resultMap = new HashMap<Integer, Double>();

        for(Map.Entry<Integer, Double> temperature:
            temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1);
        }
        return resultMap;
    }
}
