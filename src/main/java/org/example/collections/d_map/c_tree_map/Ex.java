package org.example.collections.d_map.c_tree_map;

import java.util.TreeMap;

public class Ex {
    public static void main(String[] args) {

        // TreeMap — keys SORTED (red-black tree)
        //   get/put/remove: O(log n)
        //   firstKey/lastKey/headMap/tailMap/ceilingKey navigate by order
        //   keys must be Comparable OR construct with a Comparator

        TreeMap<String, String> catalog = new TreeMap<>();

        catalog.put("978-0-13-468599-1", "Effective Java");
        catalog.put("978-0-321-35668-0", "Java Concurrency in Practice");
        catalog.put("978-0-13-235088-4", "Clean Code");
        catalog.put("978-0-201-63361-0", "Design Patterns");

        System.out.println("catalog (sorted by ISBN):");
        catalog.forEach((isbn, title) -> System.out.println("  " + isbn + " -> " + title));

        System.out.println("\nfirst ISBN  = " + catalog.firstKey());
        System.out.println("last ISBN   = " + catalog.lastKey());
        System.out.println("headMap(978-0-2...) = " + catalog.headMap("978-0-2"));
        System.out.println("tailMap(978-0-2...) = " + catalog.tailMap("978-0-2"));
        System.out.println("ceilingKey(978-0-15) = " + catalog.ceilingKey("978-0-15"));
    }
}
