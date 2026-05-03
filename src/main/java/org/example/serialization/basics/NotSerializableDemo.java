package org.example.serialization.basics;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Daca un camp dintr-un obiect Serializable refera o clasa care NU e Serializable
// -> NotSerializableException la writeObject.
public class NotSerializableDemo {

    static class BookWithLibrary implements Serializable {
        private static final long serialVersionUID = 1L;
        Library library = new Library("Centrala"); // <-- problema
    }

    public static void main(String[] args) throws Exception {
        try (var out = new ObjectOutputStream(new ByteArrayOutputStream())) {
            out.writeObject(new BookWithLibrary());
        } catch (java.io.NotSerializableException e) {
            System.out.println("NotSerializableException: " + e.getMessage());
        }
    }
}
