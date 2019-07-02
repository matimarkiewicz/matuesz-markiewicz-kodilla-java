package com.kodilla.good.patterns.challenges;

import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();

        Map<String, List<String>> movieStoreMap = movieStore.getMovies();

        final String moviesList = movieStoreMap.entrySet()
                .stream()
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.joining("! "));
        System.out.println(moviesList);
    }
}
