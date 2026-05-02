package org.example.serialization.basics;

// ATENTIE: NU implementeaza Serializable.
// Folosita in NotSerializableDemo pentru a arata ce se intampla cand
// o referinta dintr-un obiect "serializabil" trimite la o clasa care
// nu este serializabila -> NotSerializableException la runtime.
public class Library {

    private final String name;

    public Library(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Library{name='" + name + "'}";
    }
}
