package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.description.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.service.SearchEngine;

public class Main {
    public static void main(String[] args) {
        //Создание корзины
        ProductBasket basket = new ProductBasket();
        SearchEngine search = new SearchEngine();

        //Создание продукта
        try {
            SimpleProduct product1 = new SimpleProduct("Сахар", 45);
            basket.addProduct(product1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            DiscountedProduct product3 = new DiscountedProduct("Хлеб", 120, 15);
            basket.addProduct(product3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            DiscountedProduct product4 = new DiscountedProduct("Молоко", 120, 20);
            basket.addProduct(product4);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            SimpleProduct product5 = new SimpleProduct("Соль", 50);
            basket.addProduct(product5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        try {
            FixPriceProduct product2 = new FixPriceProduct("Масло");
            basket.addProduct(product2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        //Создаем статьи
        Article coffeeArticle = new Article(
                "Как выбрать зерновой кофе",
                "Хороший кофе начинается со свежей обжарки. Если вы любите насыщенный кофе, обратите внимание на арабику. Настоящий кофе бодрит с утра."
        );

        Article teaArticle = new Article(
                "Польза зелёного чая",
                "Зелёный чай содержит антиоксиданты и мягко тонизирует организм без резких скачков давления."
        );

        Article laptopArticle = new Article(
                "Обзор игровых ноутбуков 2026 года",
                "Современный ноутбук должен иметь мощную видеокарту и хорошее охлаждение. Выбирая ноутбук для работы и игр, смотрите на экран."
        );

        Article breadArticle = new Article(
                "Домашний хлеб на закваске",
                "Выпечка хлеба дома требует терпения, но аромат свежего хлеба стоит потраченного времени."
        );

        Article phoneArticle = new Article(
                "Смартфоны с лучшей камерой",
                "Флагманские модели позволяют делать отличные снимки даже в темноте."
        );

        System.out.println(basket.deleteProductByTitle("Хлеб"));
        basket.printBasket();
        System.out.println(basket.deleteProductByTitle("Гречка"));
        basket.printBasket();

        //Добавляем статьи в поисковую систему
        search.add(coffeeArticle);
        search.add(teaArticle);
        search.add(laptopArticle);
        search.add(breadArticle);
        search.add(phoneArticle);


       // System.out.println(search.search("на"));
        search.search("на").values().forEach((System.out::println));
    }

}
