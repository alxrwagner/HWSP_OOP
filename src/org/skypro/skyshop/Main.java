package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.description.Article;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.service.SearchEngine;
import org.skypro.skyshop.service.Searchable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Создание корзины
        ProductBasket basket = new ProductBasket();
        SearchEngine search = new SearchEngine(10);

        //Создание продукта
        try {
            SimpleProduct product1 = new SimpleProduct("   ", 45);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        try {
            DiscountedProduct product3 = new DiscountedProduct(null, 120, 110);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try {
            DiscountedProduct product4 = new DiscountedProduct("Молоко", 120, -1);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try {
            SimpleProduct product5 = new SimpleProduct("Соль", 0);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        FixPriceProduct product2 = new FixPriceProduct("Масло");

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

        //Добавляем статьи в поисковую систему
        search.add(coffeeArticle);
        search.add(teaArticle);
        search.add(laptopArticle);
        search.add(breadArticle);
        search.add(phoneArticle);

        //Проверка поиска с вхождениями
        try {
            System.out.println(search.findBestMatch("на"));
        } catch (BestResultNotFound e){
            System.out.println(e.getMessage());
        }

        //Проверка поиска без вхождений
        try {
            System.out.println(search.findBestMatch("bob"));
        } catch (BestResultNotFound e){
            System.out.println(e.getMessage());
        }

    }

}