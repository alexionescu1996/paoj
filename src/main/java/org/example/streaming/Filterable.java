package org.example.streaming;

@FunctionalInterface
public interface Filterable {
    boolean matches(String genre);
}
