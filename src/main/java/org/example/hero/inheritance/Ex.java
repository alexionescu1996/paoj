package org.example.hero.inheritance;

public class Ex {
    public static void main(String[] args) {

        Hero superman = new Hero("Superman", "Super Strength", 999, "Kryptonite", true);
        Hero batman = new Hero("Batman", "Intellect", 850, "No superpowers", false);
        Hero flash = new Hero("Flash", "Super Speed", 900, "Cold", true);

        Hero[] heroes = {superman, batman, flash};

        for (Hero hero : heroes) {
            System.out.println(hero);
            System.out.println("  Power: " + hero.getPowerName() + " (level " + hero.getPowerLevel() + ")");
            System.out.println("  Weakness: " + hero.getWeakness());
            System.out.println("  Lethal: " + hero.isLethal());
            System.out.println();
        }
    }
}
