package org.example.hero.metahuman;

public class Ex {
    public static void main(String[] args) {

        MetaHuman superman = new Hero("Superman", 999);
        MetaHuman batman = new Hero("Batman", 850);
        MetaHuman joker = new Villain("Joker", 400);
        MetaHuman thanos = new Villain("Thanos", 950);

        MetaHuman[] metaHumans = {superman, batman, joker, thanos};

        for (MetaHuman m : metaHumans) {
            System.out.println(m);
        }
    }
}
