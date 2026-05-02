package org.example.serialization.externalizable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// Demo Externalizable: serializare custom, controlata explicit.
// Comparatie cu serialization.basics: acolo JVM-ul face totul automat,
// aici scriem noi writeExternal/readExternal.
public class Ex {

    private static final String FILE = "book-ext.ser";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Book original = new Book("Enigma Otiliei", 75.0, "George Calinescu",
                "parola-secreta-123");

        System.out.println("INAINTE de serializare:");
        System.out.println("  " + original);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE))) {
            out.writeObject(original);
        }

        Book restored;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE))) {
            restored = (Book) in.readObject();
        }

        System.out.println("\nDUPA deserializare:");
        System.out.println("  " + restored);
        System.out.println("\nObservatii:");
        System.out.println("  - price = 0.0 pentru ca am ALES sa nu il scriem in writeExternal");
        System.out.println("  - secretNote a fost ofuscat pe disk si dezofuscat la citire");
        System.out.println("  - title si authorName au fost scrise in ordinea aleasa de noi");
    }
}
