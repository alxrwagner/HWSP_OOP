package org.skypro.skyshop.product;

public abstract class Product {
    private final String title;
    protected boolean isSpecial;

    public Product(String title ) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract int getCost();

    public boolean getIsSpecial(){
        return isSpecial;
    }

    @Override
    public String toString() {
        return title;
    }
}
