package com.kodilla.good.patterns.challenges;

import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();

        Map<String, List<String>> movieStoreMap = movieStore.getMovies();

        final String booksMovieList = movieStoreMap.entrySet()
                .stream()
                .flatMap(n -> {
                    List<String> list = new ArrayList<>();
                    list.add(n.getKey());
                    list.addAll(n.getValue());
                    return list.stream();
                })
                .collect(Collectors.joining("! "));
        System.out.println(booksMovieList);
    }
}
