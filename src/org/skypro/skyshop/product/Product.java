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

    public abstract int getPrice();

    public abstract boolean getIsSpecial();

    @Override
    public String toString() {
        return title;
    }
}
