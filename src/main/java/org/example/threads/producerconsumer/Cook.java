package org.example.threads.producerconsumer;

public class Cook implements Runnable {

    private final PizzaCounter counter;
    private final String type;

    public Cook(PizzaCounter counter, String type) {
        this.counter = counter;
        this.type = type;
    }

    @Override
    public void run() {
        int n = 0;
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(200);
                counter.put(type + "#" + (++n));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
