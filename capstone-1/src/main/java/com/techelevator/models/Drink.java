package com.techelevator.models;

public class Drink extends Item{

    public Drink(String code , String type, String name, double price, int quantity ) {
        super(code, type, name, price, quantity);
    }

    @Override
    public void getMessage() {
        System.out.println("Glug Glug, Yum!");
    }
}
