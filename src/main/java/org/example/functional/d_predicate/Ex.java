package org.example.functional.d_predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ex {
    public static void main(String[] args) {

        Predicate<Integer> isPassing = score -> score >= 50;
        Predicate<Integer> isHonors = score -> score >= 80;

        System.out.println("isPassing.test(45) = " + isPassing.test(45));
        System.out.println("isHonors.test(92)  = " + isHonors.test(92));

        Predicate<Integer> passingButNotHonors = isPassing.and(isHonors.negate());
        Predicate<Integer> passingOrHonors = isPassing.or(isHonors);
        Predicate<Integer> failing = isPassing.negate();

        System.out.println("passingButNotHonors(70) = " + passingButNotHonors.test(70));
        System.out.println("passingOrHonors(40)     = " + passingOrHonors.test(40));
        System.out.println("failing(30)             = " + failing.test(30));

        List<Integer> classScores = new ArrayList<>(List.of(92, 45, 78, 33, 88, 50, 12, 65));
        classScores.removeIf(failing);
        System.out.println("scores after removing failing students = " + classScores);
    }
}
