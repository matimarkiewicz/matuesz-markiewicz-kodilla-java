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
        productsList.put(new SugarProduct("Budy�", "MARCHEWKOWY"), 5);
        productsList.put(new CornFlakesProduct("Nestle", "SMAKO�AKI"), 46);
        productsList.put(new CornFlakesProduct("Lubella", "P�ATKI"), 32);

        return productsList;
    }

    public boolean process(Client client, Map<Product, Integer> productsOrders) {

        for (Map.Entry<Product, Integer> entry : productsOrders.entrySet()) {
            Optional<Integer> productQty = Optional.ofNullable(productsList.get(entry.getKey()));
            if (productQty.orElse(0) < entry.getValue()) {
                System.out.println("Extra Food Shop: Product is unavailable.");
                return false;
            }
        }
        return true;
    }
}