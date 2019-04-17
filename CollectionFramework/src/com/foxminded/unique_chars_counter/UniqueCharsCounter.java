package com.foxminded.unique_chars_counter;

import java.util.*;

public class UniqueCharsCounter {
    private Map<String, String> cache = new HashMap<>();
    
    public String countChars(String string) {
        if (string == null) {
            throw  new IllegalArgumentException();
        }
        
        if (!cache.containsKey(string)) {
            String stats = formStats(makeEntry(string));
            cache.put(string, stats);
        }

        return cache.get(string);
    }
    
    private Map<String, Integer> makeEntry(String string) {
        String[] chars = string.split("");
        Map<String, Integer> entry = new LinkedHashMap<>();
        
        for (String str : chars) {
            if (entry.containsKey(str)) {
                entry.put(str, entry.get(str).intValue() + 1);
            } else {
                entry.put(str, 1);
            }
        }
        
        return entry;
    }
    
    private String formStats(Map<String, Integer> entry) {
        StringBuilder sb = new StringBuilder();
        
        for (String key : entry.keySet()) {
            sb.append("\"").append(key).append("\" - ").append(entry.get(key)).append("\n");
        }
        
        return sb.toString();
    }
}
