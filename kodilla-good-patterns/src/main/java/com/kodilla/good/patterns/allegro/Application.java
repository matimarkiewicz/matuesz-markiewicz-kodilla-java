package com.kodilla.good.patterns.allegro;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Application {
    public static void main(String[] args) {
        ProductOrderRequestRetriever productOrderRequestRetriever = new ProductOrderRequestRetriever();
        ProductOrderRequest productOrderRequest = productOrderRequestRetriever.retrieve();

        ProductOrderProcessor productOrderProcessor = new ProductOrderProcessor(new MailService(), new BikeOrderService(), new BikeOrderRepository());
        productOrderProcessor.process(productOrderRequest);
    }
}