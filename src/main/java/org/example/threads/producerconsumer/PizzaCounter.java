package org.example.threads.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

// Buffer marginit (bounded buffer) pentru pattern-ul producer/consumer.
// Domeniul: o tejghea de pizzerie cu loc limitat pe blat.
//   - bucatarii (producers) pun pizza pe tejghea
//   - chelnerii  (consumers) iau pizza de pe tejghea
//   - daca tejgheaua e plina, bucatarul asteapta
//   - daca e goala, chelnerul asteapta
//
// Sincronizam totul pe `this` (metode synchronized). wait() elibereaza
// lock-ul si pune thread-ul "in adormire", notify() trezeste UN thread
// care astepta pe acelasi monitor.
public class PizzaCounter {

    private final Queue<String> counter = new LinkedList<>();
    private final int capacity;

    public PizzaCounter(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(String pizza) throws InterruptedException {
        // FOARTE IMPORTANT: while, NU if.
        // Motiv 1 (spurious wakeups): JVM-ul are voie sa trezeasca un thread
        //   din wait() chiar daca nimeni nu a chemat notify(). Daca am avea
        //   if, am pleca mai departe cu o conditie inca falsa.
        // Motiv 2: dupa notify(), alt consumer/producer poate fi servit
        //   inaintea noastra si conditia se schimba din nou.
        while (counter.size() == capacity) {
            System.out.println("  [bucatar " + Thread.currentThread().getName()
                    + "] tejghea plina, astept...");
            wait(); // elibereaza lock-ul si dormita
        }
        counter.add(pizza);
        System.out.println("  [bucatar " + Thread.currentThread().getName()
                + "] pun " + pizza + "  (acum: " + counter.size() + "/" + capacity + ")");

        // notify() trezeste UN singur thread care astepta pe acest monitor.
        // Folosim notify() pentru simplitate. notifyAll() ar fi necesar daca
        // am avea conditii diferite pentru a trezi thread-uri diferite
        // (de ex. mai multe tipuri de consumeri); altfel risti sa trezesti
        // un producer cand de fapt trebuia trezit un consumer.
        notify();
    }

    public synchronized String take() throws InterruptedException {
        while (counter.isEmpty()) {
            System.out.println("  [chelner " + Thread.currentThread().getName()
                    + "] tejghea goala, astept...");
            wait();
        }
        String pizza = counter.poll();
        System.out.println("  [chelner " + Thread.currentThread().getName()
                + "] iau " + pizza + "  (acum: " + counter.size() + "/" + capacity + ")");
        notify();
        return pizza;
    }
}
