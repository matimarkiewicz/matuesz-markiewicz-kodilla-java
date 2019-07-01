package com.kodilla.good.patterns.allegro;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductOrderRequestRetriever {

    public ProductOrderRequest retrieve() {
        User user = new User("RNowak", "Roman", "Nowak");
        LocalDateTime orderDate = LocalDateTime.of(2019, 7, 1, 12, 15);
        Product product = new Bike("Sk³adak", "Stary rower", new BigDecimal("1500"));
        int quantity = 2;

        System.out.println("Retrieve product request:");
        System.out.println("User: " + user.getUserName() +
                " Date: " + orderDate + "\n" +
                product + "\n" + "Quantity = '" + quantity + "'.");
        return new ProductOrderRequest(user, orderDate, product, quantity);
    }
}