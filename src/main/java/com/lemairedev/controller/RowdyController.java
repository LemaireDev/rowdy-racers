package com.lemairedev.controller;

import com.lemairedev.domain.Coordinates;
import com.lemairedev.domain.Grid;
import com.lemairedev.domain.Player;

public class RowdyController {
    private Grid grid;
    private Player player;

    public RowdyController(int gridSize) {
        this.grid = new Grid(gridSize);
        player = new Player();
        player.moveTo(new Coordinates(0,gridSize-1));
    }

    public Player goUp() {
        int x = player.getCoordinates().getX();
        int y = player.getCoordinates().getY()-1;
        Coordinates newCoordinates = null;
        if (y >= 0) {
            newCoordinates = new Coordinates(x, y);
            player.moveTo(newCoordinates);
        }
        return player;
    }

    public Player goDown() {
        int x = player.getCoordinates().getX();
        int y = player.getCoordinates().getY()+1;
        Coordinates newCoordinates = null;
        if (y < grid.getSize()) {
            newCoordinates = new Coordinates(x, y);
            player.moveTo(newCoordinates);
        }
        return player;
    }

    public Player goLeft() {
        int x = player.getCoordinates().getX()-1;
        int y = player.getCoordinates().getY();
        Coordinates newCoordinates = null;
        if (x >= 0) {
            newCoordinates = new Coordinates(x, y);
            player.moveTo(newCoordinates);
        }
        return player;
    }

    public Player goRight() {
        int x = player.getCoordinates().getX()+1;
        int y = player.getCoordinates().getY();
        Coordinates newCoordinates = null;
        if (x < grid.getSize()) {
            newCoordinates = new Coordinates(x, y);
            player.moveTo(newCoordinates);
        }
        return player;
    }
}
