package com.kodilla.good.patterns.food2door;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.List;

public class OrderRetriever {

    public List<OrderRequest> retrieve() {
        List<OrderRequest> orderRequestList = new ArrayList<>();

        Client client = new Client("RNowak");

        FoodProducer foodProducer = new GlutenFreeShop();

        Map<Product, Integer> productsList = new HashMap<>();
        productsList.put(new GlutenFreeProduct("Chleb", "POLAK"), 3);
        productsList.put(new GlutenFreeProduct("Bu³ka", "CHINKA"), 5);
        productsList.put(new GlutenFreeProduct("Kasza", "KATARKA"), 500);

        orderRequestList.add(new OrderRequest(client, foodProducer, productsList));

        Client client1 = new Client("WNowy");

        FoodProducer foodProducer1 = new GlutenFreeShop();

        Map<Product, Integer> productsList1 = new HashMap<>();
        productsList.put(new GlutenFreeProduct("Chleb", "POLAK"), 2);
        productsList.put(new GlutenFreeProduct("Bu³ka", "CHINKA"), 15);
        productsList.put(new GlutenFreeProduct("Kasza", "KATARKA"), 5000);

        orderRequestList.add(new OrderRequest(client1, foodProducer1, productsList1));

        Client client2 = new Client("JKowalski");

        FoodProducer foodProducer2 = new GlutenFreeShop();

        Map<Product, Integer> productsList2 = new HashMap<>();
        productsList.put(new GlutenFreeProduct("Chleb", "POLAK"), 1);
        productsList.put(new GlutenFreeProduct("Bu³ka", "CHINKA"), 3);
        productsList.put(new GlutenFreeProduct("Kasza", "KATARKA"), 1500);

        orderRequestList.add(new OrderRequest(client2, foodProducer2, productsList2));

        return orderRequestList;
    }
}
