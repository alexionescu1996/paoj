package org.example.streaming.enums;

/**
 * Enum cu campuri si metoda de verificare.
 * Rating-ul de continut pentru restrictii de varsta.
 */
public enum ContentRating {
    EVERYONE(0, "Pentru toti"),
    TEEN(13, "13+"),
    MATURE(16, "16+"),
    EXPLICIT(18, "18+ Explicit");

    private final int minAge;
    private final String label;

    ContentRating(int minAge, String label) {
        this.minAge = minAge;
        this.label = label;
    }

    public int getMinAge() {
        return minAge;
    }

    public String getLabel() {
        return label;
    }

    /**
     * Verifica daca un utilizator cu varsta data poate accesa acest continut.
     */
    public boolean isAllowedForAge(int age) {
        return age >= this.minAge;
    }
}
