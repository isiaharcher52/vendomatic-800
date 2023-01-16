package com.techelevator.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    //create a private list variable
    private List<Item> snackList;

    //we create constructor
    //it holds file object and reads through pre-written file,
    //separating each pipe
    //we parse the strings into their appropriate data types after using switch-case
    public Inventory(String path){
        this.snackList = new ArrayList<>();
        File items = new File(path);
        try (Scanner dataInput = new Scanner(items)) {
            while(dataInput.hasNextLine()) {

                String lineOfInput = dataInput.nextLine();
                String[] separation = lineOfInput.split("\\|");
                switch(separation[3]){
                    case "Chip":
                        this.snackList.add(new Chip(separation[0], separation[3],separation[1],Double.parseDouble(separation[2]),5));
                        break;
                    case "Candy":
                        this.snackList.add(new Candy(separation[0], separation[3],separation[1],Double.parseDouble(separation[2]),5));
                        break;
                    case "Drink":
                        this.snackList.add(new Drink(separation[0], separation[3],separation[1],Double.parseDouble(separation[2]),5));
                        break;
                    case "Gum":
                        this.snackList.add(new Gum(separation[0], separation[3],separation[1],Double.parseDouble(separation[2]),5));
                        break;
                }
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("The file does not exist.");
        }
    }

    public List<Item> getSnackList() {
        return snackList;
    }
}
