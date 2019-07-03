package com.kodilla.good.patterns.flights;

import java.util.*;
import java.io.*;
import java.lang.*;

public class CityFlight {
    private String departureAirport;
    private String arrivalAirport;

    public CityFlight(String departureAirport, String arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityFlight that = (CityFlight) o;

        if (!getDepartureAirport().equals(that.getDepartureAirport())) return false;
        return getArrivalAirport().equals(that.getArrivalAirport());
    }

    @Override
    public int hashCode() {
        int result = getDepartureAirport().hashCode();
        result = 31 * result + getArrivalAirport().hashCode();
        return result;
    }
}
