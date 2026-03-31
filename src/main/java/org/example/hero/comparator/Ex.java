package org.example.hero.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Ex {
    public static void main(String[] args) {

        Hero[] heroes = {
                new Hero("batman", 800),
                new Hero("superman", 999),
                new Hero("joker", 400)
        };
        System.out.println(Arrays.deepToString(heroes));


        Comparator<Hero> byPower = new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                return Integer.compare(o1.powerLevel(), o2.powerLevel());
            }
        };

        Arrays.sort(heroes, byPower);
        System.out.println(Arrays.deepToString(heroes));

        System.out.println("===");

        Comparator<Hero> byName = new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                return o1.name().compareTo(o2.name());
            }
        };
        Arrays.sort(heroes, byName);
        System.out.println(Arrays.deepToString(heroes));

    }
}
