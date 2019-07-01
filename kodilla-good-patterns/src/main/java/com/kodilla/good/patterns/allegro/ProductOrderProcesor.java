package com.kodilla.good.patterns.allegro;

import java.util.*;
import java.io.*;
import java.lang.*;

class ProductOrderProcessor {
    private InformationService informationService;
    private ProductOrderService productOrderService;
    private ProductOrderRepository productOrderRepository;

    public ProductOrderProcessor(InformationService informationService,
                                 ProductOrderService productOrderService,
                                 ProductOrderRepository productOrderRepository) {
        this.informationService = informationService;
        this.productOrderService = productOrderService;
        this.productOrderRepository = productOrderRepository;
    }

    public ProductOrderDto process(ProductOrderRequest productOrderRequest) {
        boolean isSuccessfullySold = productOrderService.sold(productOrderRequest.getUser(),
                productOrderRequest.getOrderDate(),
                productOrderRequest.getProduct(),
                productOrderRequest.getQuantity());
        if (isSuccessfullySold) {
            informationService.inform(productOrderRequest.getUser());
            productOrderRepository.createProductOrder(productOrderRequest.getUser(),
                    productOrderRequest.getOrderDate(),
                    productOrderRequest.getProduct(),
                    productOrderRequest.getQuantity());
        }else{
            System.out.println("Your order has been rejected.");
        }

        return new ProductOrderDto(productOrderRequest.getUser(),
                productOrderRequest.getOrderDate(),
                productOrderRequest.getProduct(),
                productOrderRequest.getQuantity(),
                isSuccessfullySold);
    }
}
