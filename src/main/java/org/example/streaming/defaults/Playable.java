package org.example.streaming.defaults;

/**
 * Interfata cu DEFAULT METHODS si STATIC METHODS.
 *
 * Default methods (Java 8+):
 *   - permit implementare directa in interfata
 *   - clasele care implementeaza pot sa le suprascrie sau nu
 *   - rezolva problema: "cum adaug metode noi la o interfata fara sa stric toate clasele existente?"
 *
 * Static methods in interfata:
 *   - apartin interfetei, NU pot fi suprascrise
 *   - se apeleaza prin InterfaceName.metoda()
 */
public interface Playable {

    // Metode abstracte clasice - TREBUIE implementate
    String getTitle();
    String getArtist();
    int getDurationSeconds();

    /**
     * DEFAULT METHOD - are implementare, dar poate fi suprascris.
     */
    default String play() {
        return "Now playing: " + getTitle() + " - " + getArtist()
                + " (" + formatDuration() + ")";
    }

    /**
     * Alt default method - formateaza durata.
     */
    default String formatDuration() {
        int min = getDurationSeconds() / 60;
        int sec = getDurationSeconds() % 60;
        return "%d:%02d".formatted(min, sec);
    }

    /**
     * Default method care apeleaza alta default method.
     */
    default boolean isLongerThan(Playable other) {
        return this.getDurationSeconds() > other.getDurationSeconds();
    }

    /**
     * STATIC METHOD - utilitara, apartine interfetei.
     * NU poate fi suprascris. Se apeleaza: Playable.longer(a, b)
     */
    static Playable longer(Playable a, Playable b) {
        return a.getDurationSeconds() >= b.getDurationSeconds() ? a : b;
    }

    /**
     * Static factory method in interfata.
     */
    static Playable createPreview(String title, String artist) {
        return new Playable() {
            @Override
            public String getTitle() { return title + " (Preview)"; }

            @Override
            public String getArtist() { return artist; }

            @Override
            public int getDurationSeconds() { return 30; } // preview = 30 sec
        };
    }
}
