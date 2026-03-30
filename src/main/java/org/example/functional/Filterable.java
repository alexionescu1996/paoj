package org.example.functional;

@FunctionalInterface
public interface Filterable {
    boolean matches(String genre);
}
