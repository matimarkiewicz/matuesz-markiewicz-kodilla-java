package com.kodilla.good.patterns.allegro;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.time.LocalDateTime;

public interface ProductOrderRepository {
    boolean createProductOrder(User user, LocalDateTime orderDate, Product product, int quantity);
}
