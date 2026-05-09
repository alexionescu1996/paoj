package org.example.collections.c_set.b_linked_hash_set;

import java.util.LinkedHashSet;
import java.util.Set;

public class Ex {
    public static void main(String[] args) {

        // LinkedHashSet — no duplicates, KEEPS INSERTION ORDER
        //   same O(1) average ops as HashSet, slightly higher memory

        Set<String> recentlyViewed = new LinkedHashSet<>();

        recentlyViewed.add("Headphones");
        recentlyViewed.add("Mug");
        recentlyViewed.add("Keyboard");
        recentlyViewed.add("Headphones");
        recentlyViewed.add("Speaker");

        System.out.println("recently viewed (insertion order, no duplicates):");
        System.out.println(recentlyViewed);
    }
}
