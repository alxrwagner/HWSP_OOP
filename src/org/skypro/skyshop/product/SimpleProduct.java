package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private int cost;

    public SimpleProduct(String title, int cost) {
        super(title);
        this.cost = cost;
        this.isSpecial = false;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return getTitle() + " : " + cost;
    }
}
