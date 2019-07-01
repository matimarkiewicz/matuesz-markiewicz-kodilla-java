package com.kodilla.good.patterns.allegro;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.time.LocalDateTime;
import java.util.Random;

public class BikeOrderService implements ProductOrderService {
    public boolean sold(User user, LocalDateTime orderDate, Product product, int quantity) {
        return new Random().nextBoolean();
    }
}
