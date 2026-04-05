package org.example.streaming.sealed;

// FINAL - nimeni nu mai extinde
public final class FreeSub extends Subscription {
    public FreeSub(String username) {
        super(username);
    }

    @Override
    public String toString() {
        return getUsername() + " [FREE]";
    }
}
