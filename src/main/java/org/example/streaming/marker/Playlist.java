package org.example.streaming.marker;

import org.example.streaming.enums.Genre;

import java.util.ArrayList;
import java.util.List;

/**
 * Playlist implementeaza Cloneable (pt. duplicare) + Shareable (marker interface).
 *
 * Cloneable = marker interface din java.lang.
 * Daca NU implementezi Cloneable si apelezi clone(), primesti CloneNotSupportedException.
 */
public class Playlist extends Content implements Cloneable, Shareable {
    private List<Song> songs;

    public Playlist(String title, String creator) {
        super(title, creator, Genre.POP);
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public int getTotalDuration() {
        return songs.stream().mapToInt(Song::getDurationSeconds).sum();
    }

    /**
     * Suprascriem clone() pentru a-l face public.
     * Object.clone() este protected - trebuie suprascris pentru acces din exterior.
     * Fara "implements Cloneable" -> CloneNotSupportedException la runtime!
     *
     * ATENTIE: super.clone() face SHALLOW COPY - lista songs va fi aceeasi referinta!
     * Pentru DEEP COPY, trebuie sa copiem si lista manual.
     */
    @Override
    public Playlist clone() {
        try {
            Playlist cloned = (Playlist) super.clone(); // shallow copy
            cloned.songs = new ArrayList<>(this.songs);  // deep copy pentru lista
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone not supported - dar implementam Cloneable!", e);
        }
    }

    @Override
    public String toString() {
        return title + " by " + artist + " (" + songs.size() + " melodii)";
    }
}
