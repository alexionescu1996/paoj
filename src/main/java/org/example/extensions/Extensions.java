package org.example.extensions;

interface Villain {
    void threaten();
}

interface DangerousVillain extends Villain {
    void destroy();
}

interface Immortal {
    void respawn();
}

interface SuperVillain extends DangerousVillain, Immortal {
    void ruleTheWorld();
}

class Thanos implements SuperVillain {

    public void threaten() {}

    public void destroy() {}

    public void respawn() {}

    public void ruleTheWorld() {}
}
