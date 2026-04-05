package org.example.rpg.enums;

/**
 * Enum cu metoda abstracta implementata diferit de fiecare constanta.
 */
public enum CharacterClass {
    WARRIOR {
        @Override
        public String battleCry() {
            return "For honor and glory!";
        }

        @Override
        public int baseHealth() {
            return 150;
        }
    },
    MAGE {
        @Override
        public String battleCry() {
            return "By the arcane power!";
        }

        @Override
        public int baseHealth() {
            return 80;
        }
    },
    HEALER {
        @Override
        public String battleCry() {
            return "Light shall protect us!";
        }

        @Override
        public int baseHealth() {
            return 100;
        }
    },
    ROGUE {
        @Override
        public String battleCry() {
            return "From the shadows...";
        }

        @Override
        public int baseHealth() {
            return 90;
        }
    };

    /**
     * Metoda abstracta - fiecare constanta TREBUIE sa o implementeze.
     */
    public abstract String battleCry();

    public abstract int baseHealth();
}
