package com.kodilla.good.patterns.food2door;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Map;

public class OrderRequest {
    private Client client;
    private FoodProducer foodProducer;
    private Map<Product, Integer> productOrderRequest;

    public OrderRequest(Client client, FoodProducer foodProducer, Map<Product, Integer> productOrderRequest) {
        this.client = client;
        this.foodProducer = foodProducer;
        this.productOrderRequest = productOrderRequest;
    }

    public Client getClient() {
        return client;
    }

    public FoodProducer getFoodProducer() {
        return foodProducer;
    }

    public Map<Product, Integer> getProductOrderRequest() {
        return productOrderRequest;
    }
}
