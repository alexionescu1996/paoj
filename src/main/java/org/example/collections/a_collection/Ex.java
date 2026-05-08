package org.example.collections.a_collection;

import java.util.ArrayList;
import java.util.Collection;

public class Ex {
    public static void main(String[] args) {

        Collection<String> heroes = new ArrayList<>();

        heroes.add("Superman");
        heroes.add("Batman");
        heroes.add("Wonder Woman");

        System.out.println("size      = " + heroes.size());
        System.out.println("isEmpty   = " + heroes.isEmpty());
        System.out.println("contains  = " + heroes.contains("Batman"));

        heroes.remove("Batman");
        System.out.println("after remove = " + heroes);

        Collection<String> villains = new ArrayList<>();
        villains.add("Joker");
        villains.add("Thanos");

        heroes.addAll(villains);
        System.out.println("after addAll = " + heroes);

        heroes.clear();
        System.out.println("after clear  = " + heroes + ", size=" + heroes.size());
    }
}
