package com.kodilla.good.patterns.food2door;

import java.util.Map;

public interface FoodProducer {
    boolean process(Client client, Map<Product, Integer> productsOrders);
}
