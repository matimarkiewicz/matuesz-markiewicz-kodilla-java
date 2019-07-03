package com.kodilla.good.patterns.flights;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.stream.Collectors;

public class ServiceFlight {
    private DataBaseFlight dataBaseFlight;

    public ServiceFlight(DataBaseFlight dataBaseFlight) {
        this.dataBaseFlight = dataBaseFlight;
    }

    public Set<CityFlight> availableFlightFrom(String departureAirport) {
        return dataBaseFlight.getAvailableFlight().stream()
                .filter(cityFlight -> cityFlight.getDepartureAirport().equals(departureAirport))
                .collect(Collectors.toSet());
    }

    public Set<CityFlight> availableFlightTo(String arrivalAirport) {
        return dataBaseFlight.getAvailableFlight().stream()
                .filter(cityFlight -> cityFlight.getArrivalAirport().equals(arrivalAirport))
                .collect(Collectors.toSet());
    }

    public Set<List<CityFlight>> availableCityFlight(String departureAirport, String arrivalAirport) {
        Set<List<CityFlight>> result = new HashSet<>();

        dataBaseFlight.getAvailableFlight().stream()
                .filter(cityFlight -> cityFlight.getDepartureAirport().equals(departureAirport))
                .forEach(cityFlight -> {
                    List<CityFlight> temporary = dataBaseFlight.getAvailableFlight().stream()
                            .filter(fl -> (cityFlight.getArrivalAirport().equals(fl.getDepartureAirport())
                                    && fl.getArrivalAirport().equals(arrivalAirport)))
                            .collect(Collectors.toList());

                    if (temporary.size() > 0) {
                        List<CityFlight> flightsRoute = new ArrayList<>();
                        flightsRoute.add(cityFlight);
                        flightsRoute.addAll(temporary);
                        result.add(flightsRoute);
                    }
                });
        return result;
    }
}

