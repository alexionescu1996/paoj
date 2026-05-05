package org.example.C_serialization.e_externalizable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ex {

    public static void main(String[] args) throws Exception {
        new File("data").mkdirs();

        Book original = new Book("Enigma Otiliei", "Calinescu", 75.0);
        System.out.println("before: " + original);

        try (var out = new ObjectOutputStream(new FileOutputStream("data/book-ext.ser"))) {
            out.writeObject(original);
        }

        Book restored;
        try (var in = new ObjectInputStream(new FileInputStream("data/book-ext.ser"))) {
            restored = (Book) in.readObject();
        }

        System.out.println("after:  " + restored);
        // price = 0.0 because we chose NOT to write it in writeExternal
    }
}
