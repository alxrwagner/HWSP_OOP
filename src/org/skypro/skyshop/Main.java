package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Создание корзины
        ProductBasket basket = new ProductBasket();

        //Создание продукта
        SimpleProduct product1 = new SimpleProduct("Хлеб", 45);
        FixPriceProduct product2 = new FixPriceProduct("Масло");
        DiscountedProduct product3 = new DiscountedProduct("Сметана", 120, 5);
        SimpleProduct product4 = new SimpleProduct("Соль", 85);

        //Добавление продукта в корзину
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);

        //Добавление продукта в корзину, в которой нет свободного места
        basket.addProduct(product1);
        basket.addProduct(product1);

        //Печать содержимого корзины с несколькими товарами
        basket.showAllProductsInBasket();

        //Подсчет стоимости всех продуктов в корзине
        System.out.println(basket.totalCost());

        //Поиск товара, который есть в корзине
        System.out.println(basket.checkProductByTitle("Хлеб"));

        //Поиск товара, которого нет в корзине
        System.out.println(basket.checkProductByTitle("Йогурт"));

        //Очистка корзины
        basket.clearBasket();

        //Печать содержимого пустой корзины
        basket.showAllProductsInBasket();

        //Получение стоимости пустой корзины
        System.out.println(basket.totalCost());

        // Поиск товара по имени в пустой корзине
        System.out.println(basket.checkProductByTitle("Масло"));
    }
}