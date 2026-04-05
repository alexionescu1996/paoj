package org.example.streaming.diamond;

public interface Audible {
    String getTitle();

    default String prepare() {
        return getTitle() + " -> buffer audio...";
    }
}
