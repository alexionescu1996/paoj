package org.example.streaming;

public class StreamingDemo {

    public static void run() {
        System.out.println("=== Streaming Platform ===");

        System.out.println("-- Movie (implements Watchable, Downloadable, Subtitlable) --");
        Movie movie = new Movie();
        movie.watch();
        movie.download();
        movie.showSubtitles();

        System.out.println("-- NetflixSeries (implements OriginalSeries → PremiumContent + Reviewable) --");
        NetflixSeries series = new NetflixSeries();
        series.load();
        series.streamHD();
        series.review();
        series.bingeWatch();
        System.out.println();
    }
}
