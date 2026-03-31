package org.example.hero.inheritance;

interface Flyable {
    void fly();
}

interface Shootable {
    void shoot();
}

interface Invisible {
    void vanish();
}

class Hero implements Flyable, Shootable, Invisible {

    public void fly() {}

    public void shoot() {}

    public void vanish() {}
}
