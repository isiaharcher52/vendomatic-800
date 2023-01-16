package com.techelevator.models;

public class Candy extends Item {

    public Candy(String code ,String type, String name, double price, int quantity ){
        super(code, type, name, price, quantity);
    }

    @Override
    public void getMessage() {
        System.out.println("Munch Munch, Yum!");
    }

}