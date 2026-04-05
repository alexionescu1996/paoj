package org.example.streaming.enums;

/**
 * Enum cu metoda abstracta - fiecare constanta o implementeaza diferit.
 */
public enum UserRole {
    FREE {
        @Override
        public double monthlyPrice() { return 0; }
    },
    STUDENT {
        @Override
        public double monthlyPrice() { return 14.99; }
    },
    PREMIUM {
        @Override
        public double monthlyPrice() { return 29.99; }
    };

    public abstract double monthlyPrice();
}
