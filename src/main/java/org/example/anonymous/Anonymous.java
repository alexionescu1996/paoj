package org.example.anonymous;

interface Greeter {
    void greet(String name);
}

class AnonymousExample {

    public static void main(String[] args) {

        // Anonymous class — implementare direct la locul utilizării, fără clasă separată
        Greeter heroGreeter = new Greeter() {
            @Override
            public void greet(String name) {
                System.out.println("Welcome, hero " + name + "!");
            }
        };

        heroGreeter.greet("Spider-Man");
        heroGreeter.greet("Thor");
    }
}
