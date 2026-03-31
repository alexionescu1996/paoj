package org.example.callback;

interface OnMissionComplete {
    void onComplete(String result);
}

class Mission {

    void start(String heroName, OnMissionComplete callback) {
        System.out.println(heroName + " started the mission...");
        // ... logica misiunii ...
        callback.onComplete(heroName + " saved the city!");
    }
}

class CallbackExample {

    public static void main(String[] args) {

        Mission mission = new Mission();

        // Pasăm callback-ul ca parametru — va fi apelat când misiunea se termină
        mission.start("Spider-Man", result -> System.out.println("Mission done: " + result));

        mission.start("Thor", result -> System.out.println("Mission done: " + result));
    }
}
