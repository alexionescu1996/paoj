package org.example.serialization.basics;

import java.io.Serializable;

public class Book implements Serializable {

    // Daca lipseste, JVM-ul il genereaza si orice modificare a clasei sparge fisierele vechi.
    private static final long serialVersionUID = 1L;

    private final String title;
    private final Author author;        // referinta -> graf de obiecte
    private transient String session;   // transient = NU se serializeaza

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
        this.session = "tmp-token-" + System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author=" + author + ", session=" + session + "}";
    }
}
