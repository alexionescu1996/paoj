package org.example.serialization.basics;

import java.io.Serializable;

// Author trebuie sa implementeze Serializable pentru ca Book il refera.
// Daca un camp dintr-un obiect Serializable nu este el insusi serializabil,
// JVM-ul arunca NotSerializableException la writeObject.
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String name;
    private final String country;

    public Author(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Author{name='" + name + "', country='" + country + "'}";
    }
}
