package com.codegym;

public class Product {
    private String id;
    private String name;
    private String producer;
    private double price;
    private String discription;

    public Product() {
    }

    public Product(String id, String name, String producer, double price, String discription) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.discription = discription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + producer + ", " + price + ", " + discription;
    }
}
