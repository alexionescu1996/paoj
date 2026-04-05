package org.example.streaming.diamond;

/**
 * Implementeaza AMBELE interfete -> CONFLICT pe prepare()!
 * TREBUIE sa suprascriem prepare(), altfel nu compileaza.
 */
public class VideoPodcast implements Audible, Visual {
    private String title;

    public VideoPodcast(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() { return title; }

    @Override
    public String prepare() {
        // Putem apela oricare varianta cu InterfaceName.super.metoda()
        return Audible.super.prepare() + "\n" + Visual.super.prepare();
    }
}
