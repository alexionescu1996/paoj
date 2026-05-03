package org.example.serialization.externalizable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ex {

    public static void main(String[] args) throws Exception {
        Book original = new Book("Enigma Otiliei", "Calinescu", 75.0);
        System.out.println("inainte: " + original);

        try (var out = new ObjectOutputStream(new FileOutputStream("book-ext.ser"))) {
            out.writeObject(original);
        }

        Book restored;
        try (var in = new ObjectInputStream(new FileInputStream("book-ext.ser"))) {
            restored = (Book) in.readObject();
        }

        System.out.println("dupa:    " + restored);
        // price = 0.0 pentru ca am ales sa NU il scriem in writeExternal
    }
}
