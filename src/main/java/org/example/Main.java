package org.example;

import org.example.music.MusicDemo;
import org.example.streaming.StreamingDemo;
import org.example.notifications.NotificationsDemo;
import org.example.database.DatabaseDemo;

public class Main {

    public static void main(String[] args) {
        MusicDemo.run();
        StreamingDemo.run();
        NotificationsDemo.run();
        DatabaseDemo.run();
    }
}
