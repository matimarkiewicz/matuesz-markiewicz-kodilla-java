package com.kodilla.hibernate.invoice;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Invoice {
    private long id;
    private String number;
    private List<Item> items = new ArrayList<>();

    public Invoice(String number, List<Item> items) {
        this.number = number;
        this.items = items;
    }

    public Invoice (String number){
        this.number = number;
    }

    public Invoice() {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public long getId() {
        return id;
    }

    @Column(name = "NUMBER")
    public String getNumber() {
        return number;
    }

    @OneToMany(targetEntity = Item.class, mappedBy = "Invoice", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name = "ITEM_ID", nullable = false)
    public List<Item> getItems() {
        return items;
    }

    private void setId(long id) {
        this.id = id;
    }

    private void setNumber(String number) {
        this.number = number;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
