package org.example.collections.d_map.c_tree_map;

import java.util.TreeMap;

public class Ex {
    public static void main(String[] args) {

        TreeMap<String, Integer> scores = new TreeMap<>();

        scores.put("charlie", 70);
        scores.put("alice", 95);
        scores.put("bob", 80);

        System.out.println("sorted by key = " + scores);

        System.out.println("firstKey = " + scores.firstKey());
        System.out.println("lastKey  = " + scores.lastKey());
        System.out.println("headMap(bob) = " + scores.headMap("bob"));
        System.out.println("tailMap(bob) = " + scores.tailMap("bob"));
        System.out.println("ceilingKey(b) = " + scores.ceilingKey("b"));
    }
}
