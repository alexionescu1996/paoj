package org.example.streaming.marker;

import org.example.streaming.enums.Genre;

/**
 * PodcastEpisode este Downloadable dar NU Shareable si NU Cloneable.
 * Demonstreaza cum marker interfaces permit verificari selective cu instanceof.
 *
 * (Podcast-urile pot fi descarcate offline dar nu pot fi distribuite
 * din cauza drepturilor de autor.)
 */
public class PodcastEpisode extends Content implements Downloadable {
    private int episodeNumber;

    public PodcastEpisode(String title, String host, int episodeNumber) {
        super(title, host, Genre.PODCAST);
        this.episodeNumber = episodeNumber;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    @Override
    public String toString() {
        return "Ep." + episodeNumber + " " + title + " - " + artist;
    }
}
