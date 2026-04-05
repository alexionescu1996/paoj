package org.example.streaming.marker;

/**
 * Song implementeaza Cloneable (pt duplicare playlist) si Downloadable (marker).
 */
public class Song implements Cloneable, Downloadable {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    /**
     * Object.clone() e protected -> il facem public.
     * Fara "implements Cloneable" -> CloneNotSupportedException la runtime!
     */
    @Override
    public Song clone() {
        try {
            return (Song) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return title + " - " + artist;
    }
}
