package org.example.functional.b_lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex {
    public static void main(String[] args) {

        Runnable openStore = () -> System.out.println("store open: ready to serve customers");
        openStore.run();

        Comparator<Double> byPrice = (a, b) -> Double.compare(a, b);
        System.out.println("compare(9.99, 14.50) = " + byPrice.compare(9.99, 14.50));

        Comparator<String> byNameLength = (a, b) -> {
            int la = a.length();
            int lb = b.length();
            return Integer.compare(la, lb);
        };

        List<String> products = new ArrayList<>(List.of("Headphones", "Mug", "Keyboard", "Pen"));
        products.sort(byNameLength);
        System.out.println("products by name length = " + products);
    }
}
