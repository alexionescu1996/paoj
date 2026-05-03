package org.example.threads.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

// Buffer marginit. wait() elibereaza lock-ul si dormita. notify() trezeste 1 thread.
public class PizzaCounter {

    private final Queue<String> q = new LinkedList<>();
    private final int capacity;

    public PizzaCounter(int capacity) { this.capacity = capacity; }

    public synchronized void put(String pizza) throws InterruptedException {
        // while, NU if: dupa wakeup conditia poate fi inca falsa (spurious wakeups, alt thread servit)
        while (q.size() == capacity) wait();
        q.add(pizza);
        System.out.println("put " + pizza + " (" + q.size() + "/" + capacity + ")");
        notify();
    }

    public synchronized String take() throws InterruptedException {
        while (q.isEmpty()) wait();
        String pizza = q.poll();
        System.out.println("take " + pizza + " (" + q.size() + "/" + capacity + ")");
        notify();
        return pizza;
    }
}
