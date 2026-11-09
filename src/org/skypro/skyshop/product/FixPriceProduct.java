package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 100;

    public FixPriceProduct(String title) {
        super(title);
        this.isSpecial = true;
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public boolean getIsSpecial() {
        return isSpecial;
    }

    @Override
    public String toString() {
        return getTitle() + " : Фиксированная цена " + getPrice();
    }
}
