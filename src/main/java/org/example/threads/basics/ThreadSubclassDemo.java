package org.example.threads.basics;

// Prima varianta de a porni un thread: extinzi clasa Thread si suprascrii run().
//
// Capcana clasica: daca chemi run() in loc de start(), codul ruleaza
// SECVENTIAL pe firul curent, ca un apel obisnuit de metoda.
// Doar start() cere JVM-ului sa creeze un thread nou de OS.
public class ThreadSubclassDemo extends Thread {

    private final String label;

    public ThreadSubclassDemo(String label) {
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
        System.out.println("=== run() direct (RAU): ruleaza pe main, fara concurenta ===");
        new ThreadSubclassDemo("A").run();
        new ThreadSubclassDemo("B").run();
        // Se observa ca A termina complet inainte sa inceapa B,
        // si ambele tipa "pe firul main".

        System.out.println("\n=== start() (CORECT): doua thread-uri paralele ===");
        new ThreadSubclassDemo("A").start();
        new ThreadSubclassDemo("B").start();
        // Iesirea va fi intercalata; cele doua thread-uri au nume Thread-N.
    }
}
