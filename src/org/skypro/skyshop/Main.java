package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.description.Article;
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

        // Получение стоимости пустой корзины
        System.out.println(basket.totalCost());

        // Поиск товара по имени в пустой корзине
        System.out.println(basket.checkProductByTitle("Масло"));

        System.out.println("\n--- Тестирование поиска ---");

        // 1. Создаем поисковый движок
        SearchEngine searchEngine = new SearchEngine(15);

        // 2. Добавляем товары
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);

        // 3. Создаем и добавляем статьи
        Article article1 = new Article("Как выбрать хлеб", "Хлеб должен быть свежим и ароматным.");
        Article article2 = new Article("Польза масла", "Сливочное масло содержит витамины A и D.");
        Article article3 = new Article("История сметаны", "Сметана - традиционный славянский продукт.");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        // 4. Демонстрация поиска
        System.out.println("Поиск 'Хлеб':");
        printSearchResults(searchEngine.search("Хлеб"));

        System.out.println("Поиск 'масло' (с учетом регистра):");
        printSearchResults(searchEngine.search("масло"));

        System.out.println("Поиск 'продукт':");
        printSearchResults(searchEngine.search("продукт"));

        System.out.println("Поиск отсутствующего 'Яблоко':");
        printSearchResults(searchEngine.search("Яблоко"));
    }

    private static void printSearchResults(Searchable[] results) {
        System.out.println(Arrays.toString(results));
    }
}