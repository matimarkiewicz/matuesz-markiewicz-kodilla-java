package com.kodilla.good.patterns.food2door;

import java.util.*;
import java.io.*;
import java.lang.*;

public class GlutenFreeProduct extends Product {
    private String productSpecification;

    public GlutenFreeProduct(String productName, String productSpecification) {
        super(productName);
        this.productSpecification = productSpecification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GlutenFreeProduct that = (GlutenFreeProduct) o;

        return productSpecification.equals(that.productSpecification);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + productSpecification.hashCode();
        return result;
    }
}
