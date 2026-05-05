package org.example.D_threads.g_producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

// Bounded buffer. wait() releases the lock and parks the thread.
// notify() wakes ONE thread waiting on this monitor.
public class PizzaCounter {

    private final Queue<String> q = new LinkedList<>();
    private final int capacity;

    public PizzaCounter(int capacity) { this.capacity = capacity; }

    public synchronized void put(String pizza) throws InterruptedException {
        // while, NOT if: after wakeup the condition can still be false
        // (spurious wakeups, or another thread was served first).
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
