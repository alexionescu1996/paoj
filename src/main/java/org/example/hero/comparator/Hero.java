package org.example.hero.comparator;

public record Hero(String name, int powerLevel) {

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", powerLevel=" + powerLevel +
                '}';
    }
}
