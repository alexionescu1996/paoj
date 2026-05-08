package org.example.collections.d_map.b_hash_map;

import java.util.HashMap;

public class Ex {
    public static void main(String[] args) {

        HashMap<String, Integer> wordCount = new HashMap<>();

        String[] words = {"apple", "banana", "apple", "cherry", "banana", "apple"};

        for (String word : words) {
            wordCount.merge(word, 1, Integer::sum);
        }

        System.out.println("word count = " + wordCount);

        wordCount.putIfAbsent("date", 0);
        System.out.println("after putIfAbsent = " + wordCount);

        Integer value = wordCount.getOrDefault("missing", -1);
        System.out.println("getOrDefault(missing, -1) = " + value);
    }
}
