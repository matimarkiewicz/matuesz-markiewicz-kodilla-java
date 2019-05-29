package com.kodilla.exception.test;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Searching {

    private final Map<String, Boolean> airportMap;

    public Searching() {
        airportMap = airportDataBase();
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        return findAirport(flight.getArrivalAirport()) && findAirport(flight.getDepartureAirport());
    }

    private boolean findAirport(String airportName) throws RouteNotFoundException {
        if (airportMap.containsKey(airportName)) {
            return airportMap.get(airportName);
        } else {
            throw new RouteNotFoundException("Airport doesn't exist!");
        }
    }

    private Map<String, Boolean> airportDataBase() {
        Map<String, Boolean> airportDataBase = new HashMap<>();
        airportDataBase.put("Poznan", true);
        airportDataBase.put("Warszawa", true);
        airportDataBase.put("Krakow", false);

        return airportDataBase;
    }
}
