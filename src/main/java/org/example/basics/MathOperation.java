package org.example.basics;

/**
 * Interface basics: method declarations and constants.
 *
 * The modifiers on the fields below are redundant — interfaces implicitly make
 * all fields public, static, and final. IntelliJ greys them out to signal this.
 */
public interface MathOperation {

    public static final Double PI = Math.PI;
    public static final String ERROR_MESSAGE = "Cannot divide by zero";

    void multiply(int a, int b);

    double divide(int a, int b);
}
