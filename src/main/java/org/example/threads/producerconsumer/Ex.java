package org.example.threads.producerconsumer;

public class Ex {

    public static void main(String[] args) throws InterruptedException {
        PizzaCounter counter = new PizzaCounter(3);

        Thread cook = new Thread(new Cook(counter, "Margherita"));
        Thread waiter = new Thread(new Waiter(counter));

        cook.start();
        waiter.start();

        Thread.sleep(2000);
        cook.interrupt();
        waiter.interrupt();
        cook.join();
        waiter.join();
    }
}
