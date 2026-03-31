package org.example.hero.comparable;

import java.util.Arrays;

public class Ex {
    public static void main(String[] args) {
        Villain[] heroes = {
                new Villain("dracula", 800),
                new Villain("thanos", 999),
                new Villain("joker", 400)
        };

        System.out.println(Arrays.deepToString(heroes));

        Arrays.sort(heroes);
        System.out.println(Arrays.deepToString(heroes));

    }
}
