package com.techelevator.models;

public class Chip extends Item{

    public Chip(String code , String type, String name, double price, int quantity ){
        super(code, type, name, price, quantity);
    }

    @Override
    public void getMessage() {
        System.out.println("Crunch Crunch, Yum!");
    }
}
