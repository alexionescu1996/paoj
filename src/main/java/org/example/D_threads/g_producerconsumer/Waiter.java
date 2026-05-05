package org.example.D_threads.g_producerconsumer;

public class Waiter implements Runnable {

    private final PizzaCounter counter;

    public Waiter(PizzaCounter counter) { this.counter = counter; }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                counter.take();
                Thread.sleep(400);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
