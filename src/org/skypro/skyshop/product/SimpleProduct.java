package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private int cost;

    public SimpleProduct(String title, int cost) {
        super(title);
        this.cost = cost;
        this.isSpecial = false;
    }

    @Override
    public int getPrice() {
        return cost;
    }

    @Override
    public boolean getIsSpecial() {
        return isSpecial;
    }

    @Override
    public String toString() {
        return getTitle() + " : " + cost;
    }
}
