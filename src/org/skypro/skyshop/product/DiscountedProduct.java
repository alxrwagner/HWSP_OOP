package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    private int cost;
    private int discountPercentage;

    public DiscountedProduct(String title, int cost, int discountPercentage) {
        super(title);
        if (cost <= 0){
            throw new IllegalArgumentException("Стоимость товара не может быть меньше или равна 0");
        }

        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Скидка не может быть меньше 0% или больше 100%");
        }
        
        this.cost = cost;
        this.discountPercentage = discountPercentage;
        this.isSpecial = true;
    }

    @Override
    public int getPrice() {
        return cost - ( cost * discountPercentage / 100);
    }

    @Override
    public boolean getIsSpecial() {
        return isSpecial;
    }

    @Override
    public String toString() {
        return getTitle() + " : " + getPrice() + "( скидка: " + discountPercentage + "% )";
    }
}
