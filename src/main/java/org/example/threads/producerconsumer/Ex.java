package org.example.threads.producerconsumer;

// Demo producer/consumer:
//   - 2 bucatari (producers) si 1 chelner (consumer)
//   - tejghea cu capacitate 3
//   - rulam ~3 secunde, apoi cerem politicos oprirea cu interrupt()
public class Ex {

    public static void main(String[] args) throws InterruptedException {
        PizzaCounter counter = new PizzaCounter(3);

        Thread cook1 = new Thread(new Cook(counter, "Margherita"), "cook-1");
        Thread cook2 = new Thread(new Cook(counter, "Capricciosa"), "cook-2");
        Thread waiter = new Thread(new Waiter(counter), "waiter-1");

        cook1.start();
        cook2.start();
        waiter.start();

        // Lasam pizzeria sa lucreze ~3 secunde.
        Thread.sleep(3000);

        System.out.println("\nmain: trimit interrupt -> oprire graceful\n");
        cook1.interrupt();
        cook2.interrupt();
        waiter.interrupt();

        cook1.join();
        cook2.join();
        waiter.join();
        System.out.println("main: toate thread-urile s-au oprit.");
    }
}
