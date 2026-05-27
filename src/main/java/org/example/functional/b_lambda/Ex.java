package org.example.functional.b_lambda;

import java.util.ArrayList;
import java.util.List;

public class Ex {
    public static void main(String[] args) {

        // (params) -> expression
        List<String> products = new ArrayList<>(List.of("Headphones", "Mug", "Keyboard", "Pen"));
        products.sort((a, b) -> a.length() - b.length());

        System.out.println(products);
    }
}
