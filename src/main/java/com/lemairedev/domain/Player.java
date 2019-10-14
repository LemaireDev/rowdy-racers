package com.lemairedev.domain;

public class Player {
    private Coordinates coordinates;
    private Coordinates[] lastCoordinates = new Coordinates[5];

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void moveTo(Coordinates coordinates){
        lastCoordinates[4] = lastCoordinates[3];
        lastCoordinates[3] = lastCoordinates[2];
        lastCoordinates[2] = lastCoordinates[1];
        lastCoordinates[1] = lastCoordinates[0];
        lastCoordinates[0] = coordinates;
        this.coordinates = coordinates;
    }

    public Coordinates[] getLastCoordinates() {
        return lastCoordinates;
    }
}
