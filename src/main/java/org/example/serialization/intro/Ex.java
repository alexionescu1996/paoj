package org.example.serialization.intro;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// PUNTE de la lab-ul trecut catre serializare.
//
// Pe disc nu exista "String-uri", "int-uri" sau "obiecte" — sunt doar BYTES.
// Tot ce inseamna "salvez ceva intr-un fisier" este de fapt:
//   1. transform datele in byte[]
//   2. le scriu cu un OutputStream
// La citire e invers: citesc byte[] cu un InputStream si le INTERPRETEZ.
//
// Acelasi mecanism merge pentru orice: text, imagini, audio, video.
// Diferenta e doar in cum interpretezi bytes-ii la citire.
public class Ex {

    private static final String FILE = "data.bin";

    public static void main(String[] args) throws IOException {
        String mesaj = "Salut PAOJ!";

        // String -> byte[]  (alegem encoding-ul; UTF-8 e default sigur)
        byte[] bytes = mesaj.getBytes();

        // SCRIERE: byte[] -> fisier
        try (FileOutputStream out = new FileOutputStream(FILE)) {
            out.write(bytes);
        }

        // Sa vedem ce e EFECTIV pe disc:
        System.out.print("bytes scrisi: ");
        for (byte b : bytes) System.out.print(b + " ");
        System.out.println();
        // ex: 83 97 108 117 116 32 80 65 79 74 33  -> codurile ASCII ale literelor

        // CITIRE: fisier -> byte[] -> String
        byte[] readBack;
        try (FileInputStream in = new FileInputStream(FILE)) {
            readBack = in.readAllBytes();
        }
        String restored = new String(readBack);
        System.out.println("citit inapoi: " + restored);

        // O imagine PNG pe disc incepe cu bytes-ii: 137 80 78 71 ...
        // Daca am citi un PNG cu acelasi cod, am avea byte[] corect,
        // doar ca "new String(...)" nu e interpretarea potrivita —
        // ne-ar trebui un decoder de imagine.
        //
        // Concluzie: scrierea/citirea de bytes e generica.
        // Greu este sa decizi FORMATUL si INTERPRETAREA.
        // Pentru un obiect Java cu campuri si referinte, formatul ar fi
        // complicat de inventat manual. De aici incolo: serializare —
        // JVM-ul defineste formatul si il interpreteaza pentru tine.
    }
}
