package org.example.functional.b_lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ex {
    public static void main(String[] args) {

        Runnable noArgs = () -> System.out.println("no args lambda");
        noArgs.run();

        Comparator<Integer> byValue = (a, b) -> a - b;
        System.out.println("compare(3,5) = " + byValue.compare(3, 5));

        Comparator<String> byLength = (a, b) -> {
            int la = a.length();
            int lb = b.length();
            return Integer.compare(la, lb);
        };

        List<String> words = Arrays.asList("banana", "fig", "apple", "kiwi");
        words.sort(byLength);
        System.out.println("sorted by length = " + words);
    }
}
