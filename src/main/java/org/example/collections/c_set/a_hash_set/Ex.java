package org.example.collections.c_set.a_hash_set;

import java.util.HashSet;
import java.util.Set;

public class Ex {
    public static void main(String[] args) {

        Set<String> tags = new HashSet<>();

        tags.add("java");
        tags.add("collections");
        tags.add("java");
        tags.add("oop");
        tags.add("oop");

        System.out.println("tags     = " + tags);
        System.out.println("size     = " + tags.size());
        System.out.println("contains = " + tags.contains("java"));

        tags.remove("oop");
        System.out.println("after remove = " + tags);
    }
}
