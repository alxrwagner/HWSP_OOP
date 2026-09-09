package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private Product[] products;

    public ProductBasket() {
        this.products = new Product[5];
    }

    //Добавление продукта в корзину
    public void addProduct(Product product){
//        int basketSize = products.length;
        boolean isFull = true;

        for (int i = 0; i < products.length; i++) {
            if (products[i] == null){
                products[i] = product;
                isFull = false;
                break;
            }
        }

        if (isFull){
            System.out.println("Невозможно добавить продукт!");
//            products = resize();
//            products[basketSize - 1] = product;
        }
    }

    //Подсчет стоимости всех продуктов в корзине
    public int totalCost(){
        int totalCost = 0;
        boolean isEmpty = true;
        for (Product product : products){
            if (product != null){
                totalCost += product.getCost();
                isEmpty = false;
            }
        }

        if (isEmpty){
            System.out.println("в корзине пусто");
        }
        return totalCost;
    }

    //Проверка наличия продукта в корзине по его названию
    public boolean checkProductByTitle(String title){
        boolean isEmpty = true;
        boolean isProductInBasket = false;
        for (Product product : products){
            if (product != null) {
                isEmpty = false;

                if (product.getTitle().equalsIgnoreCase(title)) {
                    isProductInBasket = true;
                    break;
                }
            }
        }
        if (isEmpty){
            System.out.println("Корзина пуста");
        }
        return isProductInBasket;
    }

    //Очистка корзины
    public void clearBasket(){
        Arrays.fill(products, null);
    }

    //Печать содержимого корзины с несколькими товарами
    public void showAllProductsInBasket(){
        boolean isEmpty = true;
        for (Product product : products){
            if (product != null){
                System.out.println(product);
                isEmpty = false;
            }
        }
        if (isEmpty){
            System.out.println("Корзина пуста");
        }
        System.out.println("Итого: " + totalCost());
    }

    //Увеличение объема корзины
//    private Product[] resize(){
//        int capacity = 2;
//        return Arrays.copyOf(products, products.length + products.length * capacity);
//    }
}
