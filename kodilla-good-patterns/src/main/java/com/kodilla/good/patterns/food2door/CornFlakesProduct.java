package com.kodilla.good.patterns.food2door;

import java.util.*;
import java.io.*;
import java.lang.*;

public class CornFlakesProduct extends Product {
    private String cornFlakesType;

    public CornFlakesProduct(String productName, String cornFlakesType) {
        super(productName);
        this.cornFlakesType = cornFlakesType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CornFlakesProduct that = (CornFlakesProduct) o;

        return cornFlakesType.equals(that.cornFlakesType);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + cornFlakesType.hashCode();
        return result;
    }
}
