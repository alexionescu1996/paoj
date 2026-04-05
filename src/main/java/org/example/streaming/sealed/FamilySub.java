package org.example.streaming.sealed;

// NON-SEALED - oricine poate extinde de aici
public non-sealed class FamilySub extends Subscription {
    private final int members;

    public FamilySub(String username, int members) {
        super(username);
        this.members = members;
    }

    public int getMembers() { return members; }

    @Override
    public String toString() {
        return getUsername() + " [FAMILY " + members + " membri]";
    }
}
