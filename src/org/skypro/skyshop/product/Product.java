package org.skypro.skyshop.product;

import org.skypro.skyshop.service.Searchable;

public abstract class Product implements Searchable {
    private final String title;
    protected boolean isSpecial;

    public Product(String title ) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getSearchTerm() {
        return getTitle();
    }

    @Override
    public String getTypeContent() {
        return "PRODUCT";
    }

    public abstract int getPrice();

    public abstract boolean getIsSpecial();

    @Override
    public String toString() {
        return title;
    }
}
