package com.techelevator.models;

public class Gum extends Item{

    public Gum(String code ,String type, String name, double price, int quantity ) {
        super(code, type, name, price, quantity);
    }

    @Override
    public void getMessage() {
        System.out.println("Chew Chew, Yum!");
    }
}
