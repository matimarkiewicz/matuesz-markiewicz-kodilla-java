package com.kodilla.good.patterns.food2door;

public class Application {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        orderService.processingOrders(new OrderRetriever().retrieve());
    }
}
