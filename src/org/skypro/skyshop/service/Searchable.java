package org.skypro.skyshop.service;

public interface Searchable {
    public String getSearchTerm();
    public String getTypeContent();
    public String getTitle();

    default String getStringRepresentation() {
        return getTitle() + " - " + getTypeContent();
    }
}
