package org.example.threads.basics;

// Demo join(): firul main asteapta sa termine alte thread-uri inainte sa
// continue. Tipic cand ai mai multe sub-task-uri paralele si vrei sa
// combini rezultatele DUPA ce toate s-au terminat.
//
// Exemplu de domeniu: "descarcam" 4 fisiere mari in paralel si masuram
// cat dureaza fata de varianta secventiala.
public class JoinDemo {

    static class FileDownloader implements Runnable {
        private final String fileName;
        private final long sizeMb;

        FileDownloader(String fileName, long sizeMb) {
            this.fileName = fileName;
            this.sizeMb = sizeMb;
        }

        @Override
        public void run() {
            System.out.println("  start  " + fileName + " (" + sizeMb + "MB)");
            try {
                // Simulam I/O: 10ms per MB
                Thread.sleep(sizeMb * 10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            System.out.println("  done   " + fileName);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FileDownloader[] tasks = {
                new FileDownloader("video.mp4", 80),
                new FileDownloader("dataset.csv", 60),
                new FileDownloader("backup.zip", 100),
                new FileDownloader("photos.tar", 40),
        };

        // ----- Secvential -----
        long t0 = System.currentTimeMillis();
        System.out.println("=== Secvential ===");
        for (FileDownloader t : tasks) {
            t.run(); // apel direct -> ruleaza sincron pe main
        }
        long secvential = System.currentTimeMillis() - t0;

        // ----- Paralel cu join() -----
        System.out.println("\n=== Paralel + join() ===");
        Thread[] threads = new Thread[tasks.length];
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < tasks.length; i++) {
            threads[i] = new Thread(tasks[i], "dl-" + i);
            threads[i].start();
        }
        // join() = "blocheaza-ma pana cand thread-ul asta s-a terminat".
        // Fara join(), main ar imprima timpul aproape instant si ar iesi
        // inainte ca descarcarile sa termine.
        for (Thread th : threads) {
            th.join();
        }
        long paralel = System.currentTimeMillis() - t1;

        System.out.println("\nSecvential: " + secvential + " ms");
        System.out.println("Paralel:    " + paralel + " ms");
        System.out.println("=> paralelismul ajuta cand task-urile sunt independente.");
    }
}
