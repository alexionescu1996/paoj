package org.example.serialization.basics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ex {

    public static void main(String[] args) throws Exception {
        Book original = new Book("Luceafarul", new Author("Eminescu"));
        System.out.println("inainte: " + original);

        try (var out = new ObjectOutputStream(new FileOutputStream("book.ser"))) {
            out.writeObject(original);
        }

        Book restored;
        try (var in = new ObjectInputStream(new FileInputStream("book.ser"))) {
            restored = (Book) in.readObject();
        }

        System.out.println("dupa:    " + restored);
        // session = null  -> transient nu s-a salvat
        // Author e refacut automat -> graf de obiecte
    }
}
