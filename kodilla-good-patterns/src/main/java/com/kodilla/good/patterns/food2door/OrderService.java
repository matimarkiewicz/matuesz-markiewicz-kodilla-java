package com.kodilla.good.patterns.food2door;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.List;

public class OrderService {

    public void processingOrders(List<OrderRequest> orderRequest) {
        orderRequest.stream()
                .map(n -> {
                    System.out.println("Order is processing " + n.getClient().getName());
                    return n.getFoodProducer().process(n.getClient(), n.getProductOrderRequest());
                })
                .forEach(h -> System.out.println("Orders finish: " + h));
    }
}
