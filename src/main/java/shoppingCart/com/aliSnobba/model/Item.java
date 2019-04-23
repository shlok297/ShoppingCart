package shoppingCart.com.aliSnobba.model;

public class Item {
    private String name;
    private double price;
    private boolean onSale;

    public Item(String name, double price, boolean onSale) {
        this.name = name;
        this.price = price;
        this.onSale = onSale;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public boolean getOnSale(){
        return onSale;
    }
}
