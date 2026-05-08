package org.example.functional.d_predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ex {
    public static void main(String[] args) {

        Predicate<Integer> isPositive = n -> n > 0;
        Predicate<Integer> isEven = n -> n % 2 == 0;

        System.out.println("isPositive.test(5)  = " + isPositive.test(5));
        System.out.println("isEven.test(7)      = " + isEven.test(7));

        Predicate<Integer> positiveAndEven = isPositive.and(isEven);
        Predicate<Integer> positiveOrEven = isPositive.or(isEven);
        Predicate<Integer> notPositive = isPositive.negate();

        System.out.println("positiveAndEven(4)  = " + positiveAndEven.test(4));
        System.out.println("positiveOrEven(-2)  = " + positiveOrEven.test(-2));
        System.out.println("notPositive(-3)     = " + notPositive.test(-3));

        List<Integer> numbers = new ArrayList<>(List.of(-3, -2, -1, 0, 1, 2, 3, 4));
        numbers.removeIf(notPositive);
        System.out.println("after removeIf(notPositive) = " + numbers);
    }
}
