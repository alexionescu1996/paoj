package org.example.serialization.basics;

import java.io.Serializable;

// Domain class care arata cum functioneaza serializarea standard:
//  - implements Serializable (interfata marker, fara metode)
//  - serialVersionUID pentru a controla compatibilitatea intre versiuni
//  - un camp transient care NU se serializeaza
//  - o referinta catre alt obiect Serializable -> graf de obiecte
public class Book implements Serializable {

    // Daca lipseste, JVM genereaza unul automat pe baza structurii clasei,
    // iar orice modificare a clasei sparge fisierele vechi.
    // Il fixam explicit ca sa controlam noi compatibilitatea.
    private static final long serialVersionUID = 1L;

    private final String title;
    private final double price;
    private final Author author;

    // transient = "nu serializa". Tipic pentru:
    //  - cache-uri recalculabile
    //  - parole / chei / sesiuni
    //  - resurse netransportabile (Thread, Socket, conexiuni DB)
    private transient String cachedDisplayName;

    public Book(String title, double price, Author author) {
        this.title = title;
        this.price = price;
        this.author = author;
        this.cachedDisplayName = computeDisplayName();
    }

    private String computeDisplayName() {
        return title + " by " + (author != null ? author.getName() : "?");
    }

    public String getCachedDisplayName() {
        return cachedDisplayName;
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', price=" + price
                + ", author=" + author
                + ", cachedDisplayName=" + cachedDisplayName + "}";
    }
}
