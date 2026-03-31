package org.example.hero.extensions;

public class Ex {
    public static void main(String[] args) {

        // static method: create abilities using factory method
        Ability laserVision = Ability.create("Laser Vision", 750);
        Ability telekinesis = Ability.create("Telekinesis", 950);

        // class that overrides default method
        HeroAbility fireBlast = new HeroAbility("Fire Blast", 880, "Fire");
        HeroAbility thunderStrike = new HeroAbility("Thunder Strike", 920, "Lightning");

        Ability[] abilities = {laserVision, telekinesis, fireBlast, thunderStrike};

        for (Ability ability : abilities) {
            // default method: getDescription()
            System.out.println(ability.getDescription());
            // default method: isOverpowered()
            System.out.println("  Overpowered: " + ability.isOverpowered());
        }

        System.out.println();

        // static method: compare
        System.out.println("Compare Fire Blast vs Thunder Strike: " + Ability.compare(fireBlast, thunderStrike));
        System.out.println("Compare Telekinesis vs Laser Vision: " + Ability.compare(telekinesis, laserVision));
    }
}
