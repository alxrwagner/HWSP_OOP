package org.skypro.skyshop.service;

public class SearchEngine {
    private Searchable[] searchables;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public Searchable[] search(String text){
        Searchable[] result = new Searchable[5];
        int counter = 0;

        for (Searchable obj : searchables) {
            if (obj != null && obj.getSearchTerm().contains(text)) {
                result[counter] = obj;
                counter++;
                if (counter == searchables.length) {
                    break;
                }
            }
        }

        return result;
    }

    public void add(Searchable obj){
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = obj;
                return;
            }
        }
    }
}
