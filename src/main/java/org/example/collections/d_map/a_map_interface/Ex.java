package org.example.collections.d_map.a_map_interface;

import java.util.HashMap;
import java.util.Map;

public class Ex {
    public static void main(String[] args) {

        Map<String, Integer> ages = new HashMap<>();

        ages.put("Alice", 30);
        ages.put("Bob", 25);
        ages.put("Carol", 28);

        System.out.println("get(Alice)       = " + ages.get("Alice"));
        System.out.println("containsKey(Bob) = " + ages.containsKey("Bob"));
        System.out.println("size             = " + ages.size());

        System.out.println("\nkeySet:");
        for (String key : ages.keySet()) {
            System.out.println("  " + key);
        }

        System.out.println("\nvalues:");
        for (Integer value : ages.values()) {
            System.out.println("  " + value);
        }

        System.out.println("\nentrySet:");
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        ages.remove("Bob");
        System.out.println("\nafter remove(Bob) = " + ages);
    }
}
