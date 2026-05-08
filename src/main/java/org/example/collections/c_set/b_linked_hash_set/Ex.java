package org.example.collections.c_set.b_linked_hash_set;

import java.util.LinkedHashSet;
import java.util.Set;

public class Ex {
    public static void main(String[] args) {

        Set<String> ordered = new LinkedHashSet<>();

        ordered.add("c");
        ordered.add("a");
        ordered.add("b");
        ordered.add("a");

        System.out.println("LinkedHashSet keeps insertion order:");
        System.out.println(ordered);
    }
}
