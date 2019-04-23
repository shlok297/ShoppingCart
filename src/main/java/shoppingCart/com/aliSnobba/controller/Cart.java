package shoppingCart.com.aliSnobba.controller;

import shoppingCart.com.aliSnobba.model.Item;

import java.util.HashMap;

public class Cart {
    HashMap<Item, Integer> listItems = new HashMap<>();

    public HashMap<Item, Integer> getItems() {
       return listItems;
    }

    public void addItem(Item item, int i) {
        listItems.put(item, i);
    }

    public String itemizedList() {
        String itemizedString = "";
        for (HashMap.Entry<Item, Integer> item : listItems.entrySet()) {
            itemizedString += item.getKey().getName() + " x" + item.getValue() + " - $" + item.getKey().getPrice();
            itemizedString += (listItems.size() <= 1) ? "" : ",";
        }
        return itemizedString;
    }


    public String itemQuantities() {
        String itemizedQuantities = "";
        for (HashMap.Entry<Item, Integer> item : listItems.entrySet()) {
            itemizedQuantities += item.getKey().getName() + " - x" + item.getValue();
            itemizedQuantities += (listItems.size() <= 1) ? "" : ",";
        }
        return itemizedQuantities;
    }

    public String onSaleItem() {
        String itemizedQuantities = "";
        for (HashMap.Entry<Item, Integer> item : listItems.entrySet()) {
            if(item.getKey().getOnSale()){
                itemizedQuantities += item.getKey().getName() + " x" + item.getValue() +" - $" +item.getKey().getPrice();
                itemizedQuantities += (listItems.size() <= 1) ? "" : ",";
            }
        }

        return itemizedQuantities;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for(HashMap.Entry<Item, Integer> item : listItems.entrySet()) {
            totalPrice += item.getValue() * item.getKey().getPrice();
        }
        return totalPrice;
    }
}
