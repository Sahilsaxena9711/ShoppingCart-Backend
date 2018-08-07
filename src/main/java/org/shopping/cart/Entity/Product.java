package org.shopping.cart.Entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

public class Product {

    private int id;
    private String name;
    private String type;
    private String brand;
    private int price;

    public Product(){

    }

    public Product(int id, String name, String type, String brand, int price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
