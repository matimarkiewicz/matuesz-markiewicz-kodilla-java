package com.kodilla.stream.world;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public final class World {

    private final List<Continent>listOfContinentsOnTheWorld = new ArrayList<>();

    public boolean addContinent(Continent continent){
        return listOfContinentsOnTheWorld.add(continent);
    }

    BigDecimal getPeopleQuantity(){
        BigDecimal peopleQtyOnTheWorld = listOfContinentsOnTheWorld.stream()
                .flatMap(continent -> continent.getListOfCountriesOnContinent().stream())
                .distinct()
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum,country) -> sum.add(country));

        return peopleQtyOnTheWorld;
    }
}
