package org.example.serialization.externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Comparatie Serializable vs Externalizable:
//
//  Serializable
//    - interfata marker (fara metode)
//    - JVM-ul "stie" sa serializeze automat toate campurile non-transient
//    - simplu, dar weak: ascunde detaliile, mai lent, mai putin compact
//
//  Externalizable extends Serializable
//    - tu scrii writeExternal / readExternal
//    - tu decizi exact ce campuri scrii, in ce ordine, ce transformari aplici
//    - OBLIGATORIU constructor public fara argumente
//      (JVM-ul cheama new Book() inainte de readExternal)
//    - mai rapid, mai compact, dar mai mult cod si mai usor de gresit
public class Book implements Externalizable {

    private static final long serialVersionUID = 1L;

    private String title;
    private double price;
    private String authorName;
    // Camp "sensibil" — vrem sa il salvam ofuscat, nu in clar.
    private String secretNote;

    // Constructor public fara argumente, OBLIGATORIU pentru Externalizable.
    // JVM-ul il cheama la deserializare; daca lipseste -> InvalidClassException.
    public Book() {
    }

    public Book(String title, double price, String authorName, String secretNote) {
        this.title = title;
        this.price = price;
        this.authorName = authorName;
        this.secretNote = secretNote;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // Decidem manual ordinea campurilor scrise.
        out.writeUTF(title);
        out.writeUTF(authorName);
        // Pretul il sarim deliberat: nu ne intereseaza sa il persistam.
        // (la deserializare va ramane 0.0, valoarea default)

        // secretNote NU e scris in clar. Aplicam o "ofuscare" simbolica
        // (in viata reala: criptare adevarata, nu reverse).
        out.writeUTF(obfuscate(secretNote));
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException {
        // Trebuie sa citim in EXACT aceeasi ordine in care am scris.
        this.title = in.readUTF();
        this.authorName = in.readUTF();
        // price ramane 0.0 — nu a fost scris.
        this.secretNote = obfuscate(in.readUTF()); // reverse e auto-invers
    }

    private static String obfuscate(String s) {
        if (s == null) return null;
        return new StringBuilder(s).reverse().toString();
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', price=" + price
                + ", authorName='" + authorName
                + "', secretNote='" + secretNote + "'}";
    }
}
