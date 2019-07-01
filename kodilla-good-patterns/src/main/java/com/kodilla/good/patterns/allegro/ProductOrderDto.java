package com.kodilla.good.patterns.allegro;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.time.LocalDateTime;

public class ProductOrderDto {

    private User user;
    private LocalDateTime orderDate;
    private Product product;
    private int quantity;
    private boolean isSuccesfullySold;

    public ProductOrderDto(final User user, final LocalDateTime orderDate, final Product product, final int quantity, final boolean isSuccesfullySold) {
        this.user = user;
        this.orderDate = orderDate;
        this.product = product;
        this.quantity = quantity;
        this.isSuccesfullySold = isSuccesfullySold;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isSuccesfullySold() {
        return isSuccesfullySold;
    }
}
