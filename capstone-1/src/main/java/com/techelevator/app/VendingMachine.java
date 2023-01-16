package com.techelevator.app;

import com.techelevator.models.Audit;
import com.techelevator.models.Inventory;
import com.techelevator.models.Item;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class VendingMachine {
    // create inventory object that passes to text file, so it knows where to look for its inventory
    private Inventory inventory;
    private List<Item> listItems;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double balance = 0.00;
    private Audit audit = new Audit();

    public void mainMenu(){
        //create scanner
        Scanner input = new Scanner(System.in);

        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");

        int choice = input.nextInt();

        //statement to return based on input selected
        //switch for choice
        //create recursion to loop through until appropriate choice is entered
        switch(choice){
            case 1:
                displayItem();
                break;
            case 2:
                purchase();
                break;
            case 3:
                exitApp();
                break;
            default:
                mainMenu();
        }
    }

    public void displayItem() {
        System.out.println(listItems.size());
        for(Item item : listItems){
            System.out.println(item.getCode() + " | " + item.getType() + " | " + item.getName() + " | " +item.getPrice() + " | " + item.getQuantity());
        }
        System.out.println();
        System.out.println();
        System.out.println();
        mainMenu();
    }
    public void purchase() {
        Scanner input2 = new Scanner(System.in);
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println("Current money provided: $" + balance);
        int purchaseInput = input2.nextInt();


        switch(purchaseInput){
            case 1:
                feedMoney();
                break;
            case 2:
                selectItem();
                break;
            case 3:
                finishTrans();
                break;
            default:
                purchase();
        }



    }
    public void feedMoney(){
        Scanner feed = new Scanner(System.in);
        System.out.println("Please enter money in (w)hole");
        double fedMoney = feed.nextDouble();
        System.out.println();
        balance += fedMoney;
        audit.writeToLog("FEED MONEY: " + "$" + fedMoney + " $" + balance);
        purchase();
    }
    public void selectItem(){
        Scanner itemSelect = new Scanner(System.in);
        System.out.println("Please select an item using code: ");
        for(Item item : listItems){
            System.out.println(item.getCode() + " | " + item.getName() + " | " + item.getPrice() + " | " + item.getQuantity());
        }
        String selectedItem = itemSelect.nextLine();
        //tell terminal to look through list of items and filter it by code and return that to snack object
        boolean foundSnack = false;
        for(Item item : listItems){
            if(item.getCode().equals(selectedItem)){
                if(balance >= item.getPrice() && item.getQuantity() > 0){
                    System.out.println("Dispensing " + item.getName());
                    item.getMessage();
                    System.out.println("Keep the change ya filthy animal: " + "$" + (balance - item.getPrice()));
                    System.out.println();
                    balance -= item.getPrice();
                    foundSnack = true;
                    item.setQuantity(item.getQuantity()-1);
                    audit.writeToLog(item.getName() + " " + item.getCode() + " $" + (balance + item.getPrice()) + " $" + balance);
                    purchase();
                }
            }


        }
        if(!foundSnack){
            System.out.println("Item not found.");
            purchase();
        }

    }
    public void finishTrans(){
        audit.writeToLog("GIVE CHANGE: " + "$" + balance + " $0.00");
        System.out.println("Thank you for your transaction. Go away.");
        System.out.println("Your change is: " + balance);
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;
        if(balance >= .25){
            quarters = (int) (balance / .25);
            balance = balance - (quarters * .25);
        }
        if(balance >= .1){
            dimes = (int) (balance / .1);
            balance = balance - (dimes * .1);
        }
        if(balance >= .05){
            nickels = (int) (balance / .05);
            balance = balance - (nickels * .05);
        }
        if(balance >= .01){
            pennies = (int) (balance / .01);
            balance = balance - (pennies * .01);
        }
        System.out.println("You get back your money in these coins: ");
        System.out.println("Quarters: " + quarters);
        System.out.println("Dimes: " + dimes);
        System.out.println("Nickels: " + nickels);
        System.out.println("Pennies: " + pennies);
        System.out.println("Lucky you...");


        balance = 0;
        System.out.println(balance);



        mainMenu();
    }
    public void exitApp() {
    }
    //created vending machine that creates inventory
    //it(inventory) will create list
    //it will get inventory and set it in inventory in a way we can manipulate
    public VendingMachine() {
        this.inventory = new Inventory("vendingmachine.csv");
        this.listItems = this.inventory.getSnackList();
        System.out.println("Welcome, please input a number!!!!!!!!!!");
        mainMenu();


    }
}
