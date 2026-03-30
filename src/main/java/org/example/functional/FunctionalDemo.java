package org.example.functional;

public class FunctionalDemo {

    public static void run() {
        System.out.println("=== Functional: @FunctionalInterface, lambdas, method references ===");

        // Lambda — one line replaces an entire anonymous class
        Playable speaker = track -> System.out.println("Now playing: " + track);
        speaker.play("Bohemian Rhapsody");
        speaker.play("Blinding Lights");

        // Another lambda — different behaviour, same interface
        Playable shuffle = track -> System.out.println("Shuffled to: " + track.toUpperCase());
        shuffle.play("Hotel California");

        // Filterable via lambda
        Filterable onlyRock = genre -> genre.equalsIgnoreCase("rock");
        System.out.println("Is 'rock' a match? " + onlyRock.matches("rock"));
        System.out.println("Is 'pop' a match?  " + onlyRock.matches("pop"));

        // Method reference — String::isEmpty used as a Filterable
        Filterable noGenre = String::isEmpty;
        System.out.println("Empty genre passes filter? " + noGenre.matches(""));

        // MusicService has 3 abstract methods — cannot use a lambda, needs anonymous class
        MusicService service = new MusicService() {
            @Override
            public void play(String trackTitle) {
                System.out.println("[Service] Streaming: " + trackTitle);
            }

            @Override
            public boolean matches(String genre) {
                return genre.equals("pop") || genre.equals("indie");
            }

            @Override
            public String recommend(String mood) {
                return mood.equals("happy") ? "Happy - Pharrell Williams" : "Someone Like You - Adele";
            }
        };

        service.play("Levitating");
        System.out.println("Matches 'indie'? " + service.matches("indie"));
        System.out.println("Recommendation: " + service.recommend("happy"));
        System.out.println();
    }
}
