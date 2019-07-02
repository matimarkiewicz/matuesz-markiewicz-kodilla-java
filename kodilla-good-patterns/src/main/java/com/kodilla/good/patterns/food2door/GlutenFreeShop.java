package com.kodilla.good.patterns.food2door;

import java.util.*;
import java.io.*;
import java.lang.*;

public class GlutenFreeShop implements FoodProducer {
    private Map<Product, Integer> productsList;

    public GlutenFreeShop() {
        productsList = createProductList();
    }

    private Map<Product, Integer> createProductList() {

        Map<Product, Integer> productsList = new HashMap<>();

        productsList.put(new GlutenFreeProduct("Chleb", "POLAK"), 23);
        productsList.put(new GlutenFreeProduct("Bu³ka", "CHINKA"), 45);
        productsList.put(new GlutenFreeProduct("Kasza", "KATARKA"), 6500);
        productsList.put(new GlutenFreeProduct("Orzechy", "W£OSZKI"), 54);

        return productsList;
    }

    public boolean process(Client client, Map<Product, Integer> productsOrders) {

        for (Map.Entry<Product, Integer> entry : productsOrders.entrySet()) {
            Optional<Integer> productQty = Optional.ofNullable(productsList.get(entry.getKey()));
            if (productQty.orElse(0) < entry.getValue()) {
                System.out.println("Gluten Free Shop: Product is unavailable.");
                return false;
            }
        }
        return true;
    }
}