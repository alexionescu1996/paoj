package org.example.serialization.basics;

import java.io.Serializable;

public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String name;

    public Author(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" + name + "}";
    }
}
