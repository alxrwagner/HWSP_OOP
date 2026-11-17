package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products;

    public ProductBasket() {
        this.products = new HashMap<>() {
        };
    }

    //Добавление продукта в корзину
    public void addProduct(Product product) {
        products.computeIfAbsent(product.getTitle(), k -> new ArrayList<>()).add(product);
    }

    //Подсчет стоимости всех продуктов в корзине
    public int totalCost() {
        int totalCost = 0;
        boolean isEmpty = true;
        for (var productList : products.values()) {
            for (Product product : productList) {
                if (product != null) {
                    totalCost += product.getPrice();
                    isEmpty = false;
                }
            }
        }

        if (isEmpty) {
            System.out.println("в корзине пусто");
        }
        return totalCost;
    }

    //Проверка наличия продукта в корзине по его названию
    public boolean checkProductByTitle(String title) {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
            return false;
        }
        if (products.containsKey(title) && !products.get(title).isEmpty()) {
            return true;
        }
        return false;
    }

    //Очистка корзины
    public void clearBasket() {
        products.clear();
    }

    //Удаление продукта по названию
    public List<Product> deleteProductByTitle(String title) {
        List<Product> deletedProducts = new ArrayList<>();
        if (products.containsKey(title) && !products.get(title).isEmpty()) {
            deletedProducts = products.get(title);
            products.remove(title);
        }
        if (deletedProducts.isEmpty()) {
            System.out.println("Список пуст");
        }
        return deletedProducts;
    }

    //Печать содержимого корзины с несколькими товарами
    public void printBasket() {
        int specialProductCounter = 0;
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            for (var productList : products.values()) {
                for (Product product : productList) {
                    if (product != null) {
                        System.out.println(product);
                        if (product.getIsSpecial()) {
                            specialProductCounter++;
                        }
                    }
                }
            }
        }
        System.out.println("Итого: " + totalCost() +
                " \nСпециальных товаров: " + specialProductCounter);
    }
}
