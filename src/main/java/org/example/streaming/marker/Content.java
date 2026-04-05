package org.example.streaming.marker;

import org.example.streaming.enums.Genre;

/**
 * Clasa de baza pentru tot continutul de pe platforma.
 */
public abstract class Content {
    protected String title;
    protected String artist;
    protected Genre genre;

    public Content(String title, String artist, Genre genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return title + " - " + artist + " [" + genre.getDisplayName() + "]";
    }
}
