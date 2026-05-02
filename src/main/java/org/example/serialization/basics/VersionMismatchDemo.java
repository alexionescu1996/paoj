package org.example.serialization.basics;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;

// Demo: InvalidClassException cand serialVersionUID difera intre
// "versiunea care a scris" si "versiunea care citeste".
//
// In viata reala scenariul e:
//   1. scrii un Book in fisier cu serialVersionUID = 1L
//   2. modifici clasa (adaugi/scoti campuri) si schimbi UID-ul
//   3. incerci sa citesti fisierul vechi -> InvalidClassException
//
// Aici simulam totul intr-un singur run: scriem un BookV1 (UID=1L),
// apoi cerem ObjectInputStream-ului sa "rezolve" descriptorul ca
// BookV2 (UID=2L). Pe acelasi nume de clasa (vezi resolveClass), JVM-ul
// compara UID-urile si arunca exceptie.
public class VersionMismatchDemo {

    static class BookV1 implements Serializable {
        private static final long serialVersionUID = 1L;
        @SuppressWarnings("unused") private final String title;
        BookV1(String title) { this.title = title; }
    }

    // "Aceeasi" clasa in alta versiune. UID schimbat -> incompatibila cu V1.
    static class BookV2 implements Serializable {
        private static final long serialVersionUID = 2L;
        @SuppressWarnings("unused") private String title;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(bytes)) {
            out.writeObject(new BookV1("Hamlet"));
        }

        // Trucul: la deserializare, cand JVM-ul vede in stream numele BookV1,
        // ii spunem "incarca de fapt BookV2". Dupa rezolvare, compara UID-ul
        // din stream (1L) cu cel al clasei locale BookV2 (2L) -> mismatch.
        try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray())) {
            @Override
            protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
                if (desc.getName().equals(BookV1.class.getName())) {
                    return BookV2.class;
                }
                return super.resolveClass(desc);
            }
        }) {
            in.readObject();
            System.out.println("Nu ar trebui sa ajungem aici.");
        } catch (InvalidClassException e) {
            System.out.println("InvalidClassException: " + e.getMessage());
            System.out.println("=> serialVersionUID din stream nu se potriveste");
            System.out.println("   cu cel din clasa curenta. Fisierul vechi este 'rupt'.");
        }
    }
}
