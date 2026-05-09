package org.example.functional.e_function;

import java.util.function.Function;

public class Ex {
    public static void main(String[] args) {

        Function<String, Integer> wordCount = review -> review.trim().isEmpty()
                ? 0
                : review.trim().split("\\s+").length;
        Function<Integer, Integer> engagementScore = words -> words * 2;

        String review = "Loved the product, fast shipping and great quality";
        System.out.println("review        = \"" + review + "\"");
        System.out.println("wordCount     = " + wordCount.apply(review));

        Function<String, Integer> reviewToScore = wordCount.andThen(engagementScore);
        System.out.println("andThen score = " + reviewToScore.apply(review));

        Function<String, Integer> composed = engagementScore.compose(wordCount);
        System.out.println("compose score = " + composed.apply(review));

        Function<String, String> identity = Function.identity();
        System.out.println("identity      = " + identity.apply(review));
    }
}
