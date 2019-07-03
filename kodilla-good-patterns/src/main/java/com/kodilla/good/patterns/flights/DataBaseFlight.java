package com.kodilla.good.patterns.flights;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Set;

public class DataBaseFlight {
    private Set<CityFlight> availableFlight;

    public DataBaseFlight(Set<CityFlight> availableFlight) {
        this.availableFlight = availableFlight;
    }

    public Set<CityFlight> getAvailableFlight() {
        return availableFlight;
    }

    public DataBaseFlight() {
    }
}
