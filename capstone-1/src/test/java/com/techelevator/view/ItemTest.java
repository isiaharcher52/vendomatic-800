package com.techelevator.view;

import org.junit.Test;

import com.techelevator.models.Item;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ItemTest {

    @Test
    public void item_returns_code_correctly(){
        Item item = new Item("A1", "Chip", "Potato Crisps", 3.05, 5) {
            @Override
            public void getMessage() {

            }
        };
        String actual = item.getCode();
        String expected = "A1";

        assertEquals(expected, actual);
    }
    @Test
    public void item_returns_type_correctly(){
        Item item = new Item("A1", "Chip", "Potato Crisps", 3.05, 5) {
            @Override
            public void getMessage() {

            }
        };
        String actual = item.getType();
        String expected = "Chip";

        assertEquals(expected, actual);
    }
    @Test
    public void item_returns_name_correctly(){
        Item item = new Item("A1", "Chip", "Potato Crisps", 3.05, 5) {
            @Override
            public void getMessage() {

            }
        };
        String actual = item.getName();
        String expected = "Potato Crisps";

        assertEquals(expected, actual);
    }
    @Test
    public void item_returns_price_correctly(){
        Item item = new Item("A1", "Chip", "Potato Crisps", 3.05, 5) {
            @Override
            public void getMessage() {

            }
        };
        double actual = item.getPrice();
        double expected = 3.05;

        assertEquals(expected, actual, 0);
    }
    @Test
    public void item_returns_quantity_correctly(){
        Item item = new Item("A1", "Chip", "Potato Crisps", 3.05, 5) {
            @Override
            public void getMessage() {

            }
        };
        int actual = item.getQuantity();
        int expected = 5;

        assertEquals(expected, actual);
    }
}
