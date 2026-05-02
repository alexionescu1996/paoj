package org.example.serialization.basics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// Demo principal pentru serializarea standard (interfata Serializable).
//
// Ce arata acest demo:
//  1. Scriem un Book intr-un fisier .ser folosind ObjectOutputStream.
//  2. Il citim inapoi cu ObjectInputStream.
//  3. Comparam obiectul inainte si dupa: campul transient revine null.
//  4. Author-ul (referit de Book) este si el persistat -> graf de obiecte.
public class Ex {

    private static final String FILE = "book.ser";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Author author = new Author("Mihai Eminescu", "Romania");
        Book original = new Book("Luceafarul", 49.90, author);

        System.out.println("INAINTE de serializare:");
        System.out.println("  " + original);
        System.out.println("  cachedDisplayName = " + original.getCachedDisplayName());

        // try-with-resources -> stream-ul este inchis automat,
        // chiar daca apare o exceptie pe parcurs.
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE))) {
            out.writeObject(original);
        }
        System.out.println("\nObiect scris in " + FILE);

        Book restored;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE))) {
            restored = (Book) in.readObject();
        }

        System.out.println("\nDUPA deserializare:");
        System.out.println("  " + restored);
        System.out.println("  cachedDisplayName = " + restored.getCachedDisplayName()
                + "   <-- transient => null, NU a fost persistat");

        System.out.println("\nGraf de obiecte: Author-ul referit de Book este recreat,");
        System.out.println("desi nu a fost serializat explicit. Asta deoarece");
        System.out.println("ObjectOutputStream urmareste recursiv toate referintele.");
    }
}
