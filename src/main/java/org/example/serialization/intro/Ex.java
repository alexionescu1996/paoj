package org.example.serialization.intro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

// PUNTE de la lab-ul trecut (fisiere + string-uri) catre serializare.
//
// Data trecuta am salvat date pe disc ca text:
//   - deschidem un PrintWriter / BufferedReader
//   - convertim manual fiecare camp la string si invers
//   - parsam noi tipurile (Double.parseDouble, etc.) si tratam exceptii
//   - format inventat de noi (separator "|") si fragil
//
// Daca obiectul are referinte la alte obiecte, treaba se complica rapid.
// Solutia "out of the box" pentru a salva un obiect intreg + grafurile lui:
// SERIALIZARE (vezi pachetele basics si externalizable).
public class Ex {

    record Book(String title, String author, double price) {}

    private static final String FILE = "book.txt";

    public static void main(String[] args) throws IOException {
        Book original = new Book("Luceafarul", "Eminescu", 49.9);

        // ----- scriere ca text -----
        try (PrintWriter out = new PrintWriter(FILE)) {
            out.println(original.title() + "|" + original.author() + "|" + original.price());
        }

        // ----- citire + parsare manuala -----
        Book restored;
        try (BufferedReader in = new BufferedReader(new FileReader(FILE))) {
            String[] parts = in.readLine().split("\\|");
            // atentie: Double.parseDouble poate arunca NumberFormatException
            restored = new Book(parts[0], parts[1], Double.parseDouble(parts[2]));
        }

        System.out.println("inainte: " + original);
        System.out.println("dupa:    " + restored);

        // Probleme cu abordarea asta:
        //   1. trebuie sa stim formatul exact la citire
        //   2. parsarea tipurilor (double, int, date) e in sarcina noastra
        //   3. daca title contine "|" -> spart
        //   4. daca Book are alt obiect inauntru (Author) -> il serializam si pe ala manual?
        // => trecem la ObjectOutputStream / ObjectInputStream.
    }
}
