package org.example.comparator;

import java.util.Arrays;

class Hero {

    String name;
    int powerLevel;

    Hero(String name, int powerLevel) {
        this.name = name;
        this.powerLevel = powerLevel;
    }

    @Override
    public String toString() {
        return name + " (" + powerLevel + ")";
    }
}

class ComparatorExample {

    public static void main(String[] args) {

        Hero[] heroes = {
            new Hero("Hawkeye",   45),
            new Hero("Thor",      95),
            new Hero("Iron Man",  80),
            new Hero("Ant-Man",   30)
        };

        // Sortare după powerLevel
        java.util.Comparator<Hero> byPower = (a, b) -> Integer.compare(a.powerLevel, b.powerLevel);

        // Sortare alfabetică după name
        java.util.Comparator<Hero> byName = (a, b) -> a.name.compareTo(b.name);

        Arrays.sort(heroes, byPower);
        System.out.println("By power: " + Arrays.toString(heroes));

        Arrays.sort(heroes, byName);
        System.out.println("By name:  " + Arrays.toString(heroes));
    }
}
