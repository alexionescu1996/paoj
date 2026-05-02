package org.example.threads.producerconsumer;

// Consumer: chelnerul ia pizza de pe tejghea si o "duce la masa".
public class Waiter implements Runnable {

    private final PizzaCounter counter;

    public Waiter(PizzaCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                String pizza = counter.take();
                Thread.sleep(400 + (long) (Math.random() * 400));
                System.out.println("  [chelner " + Thread.currentThread().getName()
                        + "] am livrat " + pizza);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
