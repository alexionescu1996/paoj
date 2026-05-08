package org.example.collections.c_set.c_tree_set;

import java.util.Comparator;
import java.util.TreeSet;

public class Ex {
    public static void main(String[] args) {

        TreeSet<Integer> sorted = new TreeSet<>();
        sorted.add(50);
        sorted.add(10);
        sorted.add(30);
        sorted.add(20);

        System.out.println("natural order = " + sorted);
        System.out.println("first = " + sorted.first());
        System.out.println("last  = " + sorted.last());
        System.out.println("headSet(30) = " + sorted.headSet(30));
        System.out.println("tailSet(30) = " + sorted.tailSet(30));

        TreeSet<String> reversed = new TreeSet<>(Comparator.reverseOrder());
        reversed.add("apple");
        reversed.add("banana");
        reversed.add("cherry");
        System.out.println("custom order  = " + reversed);
    }
}
