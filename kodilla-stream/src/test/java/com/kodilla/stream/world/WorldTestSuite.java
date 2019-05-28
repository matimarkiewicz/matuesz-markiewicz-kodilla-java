package com.kodilla.stream.world;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import org.junit.*;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity(){

        World world = new World();

        Continent africa = new Continent("Africa");
        Continent asia = new Continent("Asia");
        Continent america = new Continent("America");

        Country togo = new Country("Togo");
        Country egypt = new Country("Egypt");
        Country kenya = new Country("Kenya");
        Country japan = new Country("Japan");
        Country vietnam = new Country("Vietnam");
        Country usa = new Country("USA");
        Country mexico = new Country("Mexico");
        Country canada = new Country("Canada");

        world.addContinent(africa);
        world.addContinent(america);
        world.addContinent(asia);

        africa.addCountry(togo);
        africa.addCountry(egypt);
        africa.addCountry(kenya);

        asia.addCountry(vietnam);
        asia.addCountry(japan);

        america.addCountry(canada);
        america.addCountry(usa);
        america.addCountry(mexico);

        BigDecimal totalPeople = world.getPeopleQuantity();

        BigDecimal totalPeopleExpected = new BigDecimal("8000000");
        Assert.assertEquals(totalPeopleExpected, totalPeople);
    }
}
