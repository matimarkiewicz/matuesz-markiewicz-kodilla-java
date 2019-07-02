package com.kodilla.good.patterns.food2door;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Client {
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return getName().equals(client.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
