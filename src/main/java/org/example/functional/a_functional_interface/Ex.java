package org.example.functional.a_functional_interface;

public class Ex {
    public static void main(String[] args) {

        Greeter formal = new Greeter() {
            @Override
            public String greet(String name) {
                return "Good day, " + name;
            }
        };

        Greeter casual = name -> "Hey " + name + "!";

        System.out.println(formal.greet("Alice"));
        System.out.println(casual.greet("Bob"));
    }
}
