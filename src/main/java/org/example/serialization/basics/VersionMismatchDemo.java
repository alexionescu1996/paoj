package org.example.serialization.basics;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;

// Cand serialVersionUID din fisierul vechi != serialVersionUID din clasa curenta
// -> InvalidClassException la readObject.
public class VersionMismatchDemo {

    static class BookV1 implements Serializable {
        private static final long serialVersionUID = 1L;
    }

    static class BookV2 implements Serializable {
        private static final long serialVersionUID = 2L;
    }

    public static void main(String[] args) throws Exception {
        var bytes = new ByteArrayOutputStream();
        try (var out = new ObjectOutputStream(bytes)) {
            out.writeObject(new BookV1());
        }

        // La citire, redirectam BookV1 -> BookV2 ca sa apara mismatch-ul de UID.
        try (var in = new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray())) {
            @Override
            protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
                if (desc.getName().equals(BookV1.class.getName())) return BookV2.class;
                return super.resolveClass(desc);
            }
        }) {
            in.readObject();
        } catch (InvalidClassException e) {
            System.out.println("InvalidClassException: " + e.getMessage());
        }
    }
}
