package org.example.collections.d_map.a_map_interface;

import java.util.HashMap;
import java.util.Map;

public class Ex {
    public static void main(String[] args) {

        Map<String, Integer> grades = new HashMap<>();

        grades.put("Alice", 92);
        grades.put("Bob", 78);
        grades.put("Carol", 65);

        System.out.println("Alice's grade   = " + grades.get("Alice"));
        System.out.println("Bob enrolled?   = " + grades.containsKey("Bob"));
        System.out.println("class size      = " + grades.size());

        System.out.println("\nstudents (keySet):");
        for (String name : grades.keySet()) {
            System.out.println("  " + name);
        }

        System.out.println("\ngrades (values):");
        for (Integer grade : grades.values()) {
            System.out.println("  " + grade);
        }

        System.out.println("\ngrade book (entrySet):");
        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        grades.remove("Bob");
        System.out.println("\nafter Bob drops the class = " + grades);
    }
}
