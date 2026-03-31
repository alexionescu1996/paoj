package org.example.hero.comparable;


public record Villain(String name, int powerLevel)
        implements Comparable<Villain> {

    @Override
    public int compareTo(Villain o) {
        return Integer.compare(o.powerLevel, this.powerLevel);
    }
}
