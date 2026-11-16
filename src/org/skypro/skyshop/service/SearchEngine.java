package org.skypro.skyshop.service;

import org.skypro.skyshop.exceptions.BestResultNotFound;

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

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable result = null;
        int countMaxMatches = 0;
        int countMatches;
        for (Searchable obj : searchables){
            if (obj != null) {
                countMatches = countSubstringOccurrences(obj, search);
                if (countMatches > countMaxMatches) {
                    countMaxMatches = countMatches;
                    result = obj;
                }
            }
        }

        if (result == null) {
            throw new BestResultNotFound("Не нашлось ни одной подходяще статьи по запросу : " + "\"" + search + "\"");
        }
        return result;
    }

    private int countSubstringOccurrences(Searchable obj, String substring){
        String str = obj.getSearchTerm();
        int count = 0;
        int index = 0;
        int indexSubstring = str.indexOf(substring, index);

        while (indexSubstring != -1) {
            count++;
            index = indexSubstring + substring.length();
            indexSubstring = str.indexOf(substring, index);
        }
        return count;
    }
}
