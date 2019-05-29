package com.kodilla.exception.test;

import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Flight poznanWarszawa = new Flight("Poznan", "Warszawa");
        Flight krakowPoznan = new Flight("Krakow", "Poznan");
        Flight warszawaKrakow = new Flight("Warszawa", "Krakow");

        Searching searching = new Searching();

        try {
            boolean ePoznanWarszawa = searching.findFlight(poznanWarszawa);
            System.out.println("Flight Poznan - Warszawa: " + ePoznanWarszawa);
        } catch (RouteNotFoundException e) {
            System.out.println("Please input correct airport.");
        }

        try {
            boolean eKrakowPoznan = searching.findFlight(krakowPoznan);
            System.out.println("Flight Krakow - Poznan: " + eKrakowPoznan);
        } catch (RouteNotFoundException e) {
            System.out.println("Please input correct airport.");
        }

        try {
            boolean eWarszawaKrakow = searching.findFlight(warszawaKrakow);
            System.out.println("Flight Warszawa - Krakow: " + eWarszawaKrakow);
        } catch (RouteNotFoundException e) {
            System.out.println("Please input correct airport.");

        } finally {
            System.out.println("See You later.");
        }
    }
}
