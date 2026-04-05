package org.example.streaming.marker;

/**
 * LiveStream NU implementeaza Downloadable si NU e Cloneable.
 * Nu poate fi descarcat, nu poate fi duplicat.
 */
public class LiveStream {
    private String title;

    public LiveStream(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "LIVE: " + title;
    }
}
