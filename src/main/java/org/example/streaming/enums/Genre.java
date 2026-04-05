package org.example.streaming.enums;

/**
 * Enum cu campuri, constructor, metode.
 * Fiecare gen are un emoji si o descriere.
 */
public enum Genre {
    POP("Pop", "Muzica populara moderna"),
    ROCK("Rock", "Chitare electrice si energie"),
    HIP_HOP("Hip-Hop", "Ritmuri si rime"),
    JAZZ("Jazz", "Improvizatie si suflet"),
    ELECTRONIC("Electronic", "Sintetizatoare si beat-uri"),
    CLASSICAL("Clasica", "Muzica orchestrala"),
    R_AND_B("R&B", "Rhythm and Blues"),
    PODCAST("Podcast", "Continut vorbit");

    private final String displayName;
    private final String description;

    Genre(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Returneaza un gen recomandat pe baza celui curent.
     */
    public Genre getRecommendation() {
        return switch (this) {
            case POP -> R_AND_B;
            case ROCK -> ELECTRONIC;
            case HIP_HOP -> R_AND_B;
            case JAZZ -> CLASSICAL;
            case ELECTRONIC -> POP;
            case CLASSICAL -> JAZZ;
            case R_AND_B -> HIP_HOP;
            case PODCAST -> PODCAST;
        };
    }

    /**
     * Metoda statica: genereaza un gen random (pentru "Discover Weekly").
     */
    public static Genre randomGenre() {
        Genre[] genres = values();
        int index = (int) (Math.random() * genres.length);
        return genres[index];
    }
}
