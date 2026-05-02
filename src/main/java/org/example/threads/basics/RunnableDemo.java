package org.example.threads.basics;

// A doua varianta — si cea preferata — de a porni un thread:
// implementezi Runnable si pasezi instanta unui Thread.
//
// De ce e mai buna decat "extends Thread"?
//   1. Java permite o singura mostenire. Daca extinzi Thread, "pierzi"
//      sansa sa extinzi alta clasa de domeniu.
//   2. Separare de responsabilitati: Runnable = "ce sa fac",
//      Thread = "cum sa fie executat". Acelasi Runnable poate fi
//      rulat de mai multe ori, in mai multe thread-uri sau de un
//      ExecutorService (care vine intr-un curs viitor).
public class RunnableDemo implements Runnable {

    private final String label;

    public RunnableDemo(String label) {
        this.label = label;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("[" + label + "] pas " + i
                    + " pe firul " + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public static void main(String[] args) {
        Runnable taskA = new RunnableDemo("A");
        Runnable taskB = new RunnableDemo("B");

        new Thread(taskA, "worker-A").start();
        new Thread(taskB, "worker-B").start();

        // Bonus: Runnable e interfata functionala -> lambda.
        new Thread(() -> System.out.println(
                "[lambda] salut din " + Thread.currentThread().getName()),
                "worker-lambda").start();
    }
}
