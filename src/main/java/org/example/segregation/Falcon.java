package org.example.segregation;

public class Falcon implements Flyable {

    @Override
    public void fly(int altitudeMeters) {
        System.out.println("Falcon soars to " + altitudeMeters + "m!");
    }
}
