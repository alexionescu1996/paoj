package org.example.C_serialization.c_notserializable;

import java.io.ByteArrayOutputStream;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// If a Serializable object holds a reference to a class that is NOT
// Serializable, writeObject throws NotSerializableException at runtime.
// Fixes: make the referenced class Serializable, mark the field transient,
// or use Externalizable (see e_externalizable).

public class Ex {

    // Plain class - does NOT implement Serializable.
    static class Library {
        @SuppressWarnings("unused") String name = "Centrala";
    }

    static class BookWithLibrary implements Serializable {
        private static final long serialVersionUID = 1L;
        @SuppressWarnings("unused") Library library = new Library(); // <-- problem
    }

    public static void main(String[] args) throws Exception {
        try (var out = new ObjectOutputStream(new ByteArrayOutputStream())) {
            out.writeObject(new BookWithLibrary());
        } catch (NotSerializableException e) {
            System.out.println("NotSerializableException: " + e.getMessage());
        }
    }
}
