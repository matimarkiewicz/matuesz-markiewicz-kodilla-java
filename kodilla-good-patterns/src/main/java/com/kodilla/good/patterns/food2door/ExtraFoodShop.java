package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ExtraFoodShop implements FoodProducer {
    private Map<Product, Integer> productsList;

    public ExtraFoodShop() {
        productsList = createProductList();
    }

    private Map<Product, Integer> createProductList() {

        Map<Product, Integer> productsList = new HashMap<>();

        productsList.put(new SugarProduct("Kisiel", "BURACZANY"), 15);
        productsList.put(new SugarProduct("Budyñ", "MARCHEWKOWY"), 5);

        return productsList;
    }

    public boolean process(Client client, Map<Product, Integer> productsOrders) {

        for (Map.Entry<Product, Integer> entry : productsOrders.entrySet()) {
            Optional<Integer> productQty = Optional.ofNullable(productsList.get(entry.getKey()));
            if (productQty.orElse(0) < entry.getValue()) {
                System.out.println("ExtraFoodShop: Product is unavailable.");
                return false;
            }
        }
        return true;
    }
}