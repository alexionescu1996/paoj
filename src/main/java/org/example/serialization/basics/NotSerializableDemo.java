package org.example.serialization.basics;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Demo: ce se intampla cand un obiect "serializabil" tine o referinta
// catre o clasa care NU implementeaza Serializable.
//
// Library NU implementeaza Serializable -> JVM-ul arunca
// NotSerializableException atunci cand incearca sa scrie campul.
//
// Solutii in viata reala:
//  - faci clasa referita Serializable, sau
//  - marchezi campul transient (si il reconstruiesti dupa deserializare), sau
//  - implementezi Externalizable si decizi tu ce scrii.
public class NotSerializableDemo {

    static class BookWithLibrary implements Serializable {
        private static final long serialVersionUID = 1L;
        private final String title;
        private final Library library; // <-- problema

        BookWithLibrary(String title, Library library) {
            this.title = title;
            this.library = library;
        }

        @Override
        public String toString() {
            return "BookWithLibrary{title='" + title + "', library=" + library + "}";
        }
    }

    public static void main(String[] args) throws IOException {
        BookWithLibrary book = new BookWithLibrary(
                "Istoria literaturii romane",
                new Library("Biblioteca Centrala")
        );

        // Scriem in memorie (ByteArrayOutputStream) ca sa nu mai facem fisier;
        // exceptia tot apare, e generata de ObjectOutputStream.
        try (ObjectOutputStream out = new ObjectOutputStream(new ByteArrayOutputStream())) {
            out.writeObject(book);
            System.out.println("Nu s-a aruncat exceptie (nu ar trebui sa ajungem aici).");
        } catch (NotSerializableException e) {
            System.out.println("NotSerializableException la: " + e.getMessage());
            System.out.println("=> Library nu implementeaza Serializable.");
        }
    }
}
