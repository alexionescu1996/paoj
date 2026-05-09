package org.example.collections.c_set.a_hash_set;

import java.util.HashSet;
import java.util.Set;

public class Ex {
    public static void main(String[] args) {

        // HashSet — no duplicates, NO ordering guarantees
        //   add/contains/remove: O(1) average (depends on hashCode quality)

        Set<String> recipients = new HashSet<>();

        recipients.add("alice@example.com");
        recipients.add("bob@example.com");
        recipients.add("alice@example.com");
        recipients.add("carol@example.com");
        recipients.add("bob@example.com");

        System.out.println("recipients (deduped) = " + recipients);
        System.out.println("unique count         = " + recipients.size());
        System.out.println("contains bob         = " + recipients.contains("bob@example.com"));

        recipients.remove("carol@example.com");
        System.out.println("after unsubscribe    = " + recipients);
    }
}
