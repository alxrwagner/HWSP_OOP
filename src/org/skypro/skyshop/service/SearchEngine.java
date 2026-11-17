package org.skypro.skyshop.service;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public Map<String, Searchable> search(String text){
        Map<String, Searchable> result = new TreeMap<>();

        for (Searchable obj : searchables) {
            if (obj != null && obj.getSearchTerm().contains(text)) {
                result.put(obj.getTitle(), obj);
            }
        }
        return result;
    }

    public void add(Searchable obj){
        if (obj != null){
            searchables.add(obj);
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
