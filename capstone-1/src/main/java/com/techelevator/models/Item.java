package com.techelevator.models;

public abstract class Item {
    private String name;
    private double price;
    private int quantity;
    private String code;
    private String type;



    public Item(String code ,String type, String name, double price, int quantity ){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.code = code;
        this.type = type;
    }

    public abstract void getMessage();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
