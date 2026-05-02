package org.example.threads.producerconsumer;

// Producer: bucatarul pune pizza pe tejghea la intervale aleatoare.
public class Cook implements Runnable {

    private final PizzaCounter counter;
    private final String pizzaType;

    public Cook(PizzaCounter counter, String pizzaType) {
        this.counter = counter;
        this.pizzaType = pizzaType;
    }

    @Override
    public void run() {
        int n = 0;
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(200 + (long) (Math.random() * 300));
                counter.put(pizzaType + "#" + (++n));
            }
        } catch (InterruptedException e) {
            // interrupt primit fie din sleep, fie din wait() in put().
            // Ambele inseamna "opreste-te". Pastram flag-ul si iesim.
            Thread.currentThread().interrupt();
        }
    }
}
