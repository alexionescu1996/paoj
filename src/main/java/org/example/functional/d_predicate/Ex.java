package org.example.functional.d_predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ex {
    public static void main(String[] args) {

        // Predicate<T> = boolean test(T)
        Predicate<Integer> isPassing = score -> score >= 50;

        List<Integer> scores = new ArrayList<>(List.of(92, 45, 78, 33, 50));
        scores.removeIf(isPassing.negate());

        System.out.println("passing scores = " + scores);
    }
}
