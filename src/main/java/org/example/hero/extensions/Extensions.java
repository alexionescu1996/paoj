package org.example.hero.extensions;

interface Villain {
    void threaten();
}

interface DangerousVillain extends Villain {
    void destroy();
}

interface Immortal {
    void respawn();
}

interface Vampire extends DangerousVillain, Immortal {
    void drainLife();
}

class Dracula implements Vampire {

    public void threaten() {}

    public void destroy() {}

    public void respawn() {}

    public void drainLife() {}
}
