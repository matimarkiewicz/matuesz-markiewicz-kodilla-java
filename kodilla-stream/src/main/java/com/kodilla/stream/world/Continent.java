package com.kodilla.stream.world;

import java.util.*;
import java.lang.*;
import java.io.*;

public final class Continent {

    private final String continentName;
    private final List<Country> listOfCountriesOnContinent = new ArrayList<>();

    public Continent(String continentName) {
        this.continentName = continentName;
    }

    public String getContinentName() {
        return continentName;
    }

    public boolean addCountry(Country country) {
        return listOfCountriesOnContinent.add(country);
    }

    List<Country> getListOfCountriesOnContinent() {
        return new ArrayList<>(listOfCountriesOnContinent);
    }
}
