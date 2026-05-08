package org.example.collections.e_iterator;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class Ex {
    public static void main(String[] args) {

        List<String> items = new ArrayList<>();
        items.add("alpha");
        items.add("beta");
        items.add("gamma");
        items.add("delta");

        System.out.println("--- iterate with hasNext / next ---");
        Iterator<String> it = items.iterator();
        while (it.hasNext()) {
            String value = it.next();
            System.out.println("value = " + value);
        }

        System.out.println("\n--- safe remove via Iterator.remove ---");
        Iterator<String> remover = items.iterator();
        while (remover.hasNext()) {
            String value = remover.next();
            if (value.startsWith("a") || value.startsWith("b")) {
                remover.remove();
            }
        }
        System.out.println("after iterator remove = " + items);

        System.out.println("\n--- ConcurrentModificationException demo ---");
        List<String> fresh = new ArrayList<>();
        fresh.add("one");
        fresh.add("two");
        fresh.add("three");
        fresh.add("four");
        try {
            for (String value : fresh) {
                if (value.equals("two")) {
                    fresh.remove(value);
                }
            }
        } catch (ConcurrentModificationException ex) {
            System.out.println("caught: " + ex.getClass().getSimpleName());
        }
    }
}
