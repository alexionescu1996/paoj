package org.example.collections.e_iterator;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class Ex {
    public static void main(String[] args) {

        List<String> inbox = new ArrayList<>();
        inbox.add("Project update");
        inbox.add("[SPAM] you won a prize!");
        inbox.add("Meeting at 10");
        inbox.add("[SPAM] click here now");
        inbox.add("Lunch?");

        System.out.println("--- iterate inbox with hasNext / next ---");
        Iterator<String> it = inbox.iterator();
        while (it.hasNext()) {
            String email = it.next();
            System.out.println("email: " + email);
        }

        System.out.println("\n--- delete spam via Iterator.remove ---");
        Iterator<String> cleaner = inbox.iterator();
        while (cleaner.hasNext()) {
            String email = cleaner.next();
            if (email.startsWith("[SPAM]")) {
                cleaner.remove();
            }
        }
        System.out.println("after cleanup = " + inbox);

        System.out.println("\n--- ConcurrentModificationException demo ---");
        List<String> mailingList = new ArrayList<>();
        mailingList.add("alice@example.com");
        mailingList.add("bouncing@bad.example");
        mailingList.add("bob@example.com");
        mailingList.add("carol@example.com");
        try {
            for (String email : mailingList) {
                if (email.endsWith("@bad.example")) {
                    mailingList.remove(email);
                }
            }
        } catch (ConcurrentModificationException ex) {
            System.out.println("caught: " + ex.getClass().getSimpleName());
        }
    }
}
