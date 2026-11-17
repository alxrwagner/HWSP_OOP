package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private List<Product> products;

    public ProductBasket() {
        this.products = new ArrayList<>() {
        };
    }

    //Добавление продукта в корзину
    public void addProduct(Product product) {
        products.add(product);
    }

    //Подсчет стоимости всех продуктов в корзине
    public int totalCost() {
        int totalCost = 0;
        boolean isEmpty = true;
        for (Product product : products) {
            if (product != null) {
                totalCost += product.getPrice();
                isEmpty = false;
            }
        }

        if (isEmpty) {
            System.out.println("в корзине пусто");
        }
        return totalCost;
    }

    //Проверка наличия продукта в корзине по его названию
    public boolean checkProductByTitle(String title) {
        boolean isEmpty = true;
        boolean isProductInBasket = false;
        for (Product product : products) {
            if (product != null) {
                isEmpty = false;

                if (product.getTitle().equalsIgnoreCase(title)) {
                    isProductInBasket = true;
                    break;
                }
            }
        }
        if (isEmpty) {
            System.out.println("Корзина пуста");
        }
        return isProductInBasket;
    }

    //Очистка корзины
    public void clearBasket() {
        products.clear();
    }

    //Удаление продукта по названию
    public List<Product> deleteProductByTitle(String title) {
        List<Product> deletedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getTitle().equalsIgnoreCase(title)) {
                deletedProducts.add(product);
                iterator.remove();
            }
        }
        if (deletedProducts.isEmpty()){
            System.out.println("Список пуст");
        }
        return deletedProducts;
    }

    //Печать содержимого корзины с несколькими товарами
    public void printBasket() {
        boolean isEmpty = true;
        int specialProductCounter = 0;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
                if (product.getIsSpecial()) {
                    specialProductCounter++;
                }
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("Корзина пуста");
        }
        System.out.println("Итого: " + totalCost() +
                " \nСпециальных товаров: " + specialProductCounter);
    }
}
