package org.example.streaming.diamond;

public interface Visual {
    String getTitle();

    // ACEEASI semnatura ca in Audible -> CONFLICT!
    default String prepare() {
        return getTitle() + " -> buffer video...";
    }
}
