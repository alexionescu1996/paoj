package org.example.comparable;

import java.util.Arrays;

class Hero implements java.lang.Comparable<Hero> {

    String name;
    int powerLevel;

    Hero(String name, int powerLevel) {
        this.name = name;
        this.powerLevel = powerLevel;
    }

    @Override
    public int compareTo(Hero other) {
        return Integer.compare(this.powerLevel, other.powerLevel);
    }

    @Override
    public String toString() {
        return name + " (" + powerLevel + ")";
    }
}

class ComparableExample {

    public static void main(String[] args) {

        Hero[] heroes = {
            new Hero("Hawkeye",   45),
            new Hero("Thor",      95),
            new Hero("Iron Man",  80),
            new Hero("Ant-Man",   30)
        };

        Arrays.sort(heroes); // folosește compareTo

        System.out.println(Arrays.toString(heroes));
        // [Ant-Man (30), Hawkeye (45), Iron Man (80), Thor (95)]
    }
}
