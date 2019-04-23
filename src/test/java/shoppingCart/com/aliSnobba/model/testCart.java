package shoppingCart.com.aliSnobba.model;

import org.junit.Before;
import org.junit.Test;
import shoppingCart.com.aliSnobba.controller.Cart;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class testCart {
    private Cart cart;

    @Before
    public void SetUp() {
        cart = new Cart();
    }

    @Test
    public void getItems_cartIsEmpty() {
        // Arrange
        HashMap<Item, Integer> expectedList = new HashMap<>();

        // Act
        HashMap<Item, Integer> actualList = cart.getItems();

        // Assert
        assertEquals(expectedList, actualList);
    }

    @Test
    public void addItem_AddItemsQtyOne() {
        // Arrange
        Item itemOne = new Item("Soap", 10.0, true);
        HashMap<Item, Integer> expectedItems = new HashMap<>();
        expectedItems.put(itemOne, 1);

        // Act
        cart.addItem(itemOne, 1);
        HashMap<Item, Integer> actualItems = cart.getItems();

        // Assert
        assertEquals(expectedItems, actualItems);
    }

    @Test
    public void itemizedList_getCorrectFormat(){
        //Arrange
        Item itemOne = new Item("Shampoo", 100.00, true);
        Item itemTwo = new Item("Soap", 100.00, true);
        cart.addItem(itemOne, 2);
        cart.addItem(itemTwo, 3);
        String expectedItemizedList = "Shampoo x2 - $100.0,Soap x3 - $100.0,";

        //Act
        String actualItemizedList = cart.itemizedList();

        //Assert
        assertEquals(expectedItemizedList, actualItemizedList);
    }

    @Test
    public void itemQuantities_getCorrectFormat() {
        //Arrange
        Item itemone = new Item("Handbag",1200,true);
        cart.addItem(itemone,2);
        String expectedItemizedQuantities = "Handbag - x2";

        //Act
        String actualItemizedQuantities = cart.itemQuantities();

        //Assert
        assertEquals(expectedItemizedQuantities,actualItemizedQuantities);
    }

    @Test
    public void onSaleItems_ItemsOnSale() {
        //Arrange
        Item itemone = new Item("Shoes", 300, true);
        cart.addItem(itemone, 3);
        String expectedOnSaleItem = "Shoes x3 - $300.0";

        //Act
        String actualOnSaleItem = cart.onSaleItem();

        //Assert
        assertEquals(expectedOnSaleItem, actualOnSaleItem);
    }

    @Test
    public void onSaleItems_ItemsOffSale() {
        //Arrange
        Item itemone = new Item("Shoes", 300, false);
        cart.addItem(itemone, 3);
        String expectedOnSaleItem = "";

        //Act
        String actualOnSaleItem = cart.onSaleItem();

        //Assert
        assertEquals(expectedOnSaleItem, actualOnSaleItem);
    }

    @Test
    public void getTotalPrice_QtyXPrice() {
        //Arrange
        Item itemOne = new Item("Shampoo", 100.00, true);
        Item itemTwo = new Item("Soap", 100.00, true);
        Item itemThree = new Item("Bag", 150.0, true);
        cart.addItem(itemOne, 2);
        cart.addItem(itemTwo, 3);
        cart.addItem(itemThree, 2);
        double expectedTotalPrice = 800.0;

        //Act
        double actualTotalPrice = cart.getTotalPrice();

        //Assert
        assertEquals(expectedTotalPrice, actualTotalPrice, 0.001);
    }
}

