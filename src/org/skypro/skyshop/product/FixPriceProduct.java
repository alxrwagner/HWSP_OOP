package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    public static final int FIX_PRICE = 100;

    public FixPriceProduct(String title) {
        super(title);
        this.isSpecial = true;
    }

    @Override
    public int getCost() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return getTitle() + " : " + getCost();
    }
}
