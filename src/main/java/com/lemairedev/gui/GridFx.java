package com.lemairedev.gui;

import com.lemairedev.domain.Coordinates;
import com.lemairedev.domain.Player;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class GridFx extends GridPane {
    private int gridSize;
    private SquareFx bluePlayer;
    private SquareFx redPlayer;

    public GridFx() {

        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void createGameGrid(GridPane grid, int size) {
        this.gridSize = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                SquareFx squareFx = new SquareFx(60, 60);
                grid.add(squareFx, i, j);
            }
        }
    }

    private Node getNodeFromGridPane(int col, int row) {
        for (Node node : this.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    public void addCars() {
        bluePlayer = (SquareFx) getNodeFromGridPane(0, gridSize - 1);
        bluePlayer.setBluePlayer();
        redPlayer = (SquareFx) getNodeFromGridPane(gridSize - 1, 0);
        redPlayer.setRedPlayer();
    }

    public void addWalls() {
        SquareFx wall = (SquareFx) getNodeFromGridPane(5, 5);
        SquareFx wall2 = (SquareFx) getNodeFromGridPane(6, 5);
        SquareFx wall3 = (SquareFx) getNodeFromGridPane(7, 5);
        wall.setWall();
        wall2.setWall();
        wall3.setWall();
    }

    public void moveBluePlayerTo(Player player) {
        if (player.getCoordinates() != null) {
            setTrail(player);
            bluePlayer = (SquareFx) getNodeFromGridPane(player.getCoordinates().getX(), player.getCoordinates().getY());
            bluePlayer.setBluePlayer();
        }
    }

    private void setTrail(Player player) {
        Coordinates[] lastCoordinates = player.getLastCoordinates();
        for (int i = 1; i <= 3; i++) {
            if (lastCoordinates[i] != null) {
                SquareFx trail = (SquareFx) getNodeFromGridPane(lastCoordinates[i].getX(), lastCoordinates[i].getY());
                trail.setBlueLightTrail();
            }
        }
        if (lastCoordinates[4] != null) {
            SquareFx noMoreTrailSquare = (SquareFx) getNodeFromGridPane(lastCoordinates[4].getX(), lastCoordinates[4].getY());
            noMoreTrailSquare.setDefault();
        }
    }

    public void goUp() {
        bluePlayer = (SquareFx) getNodeFromGridPane(0, gridSize - 2);
        bluePlayer.setBluePlayer();

        SquareFx trail = (SquareFx) getNodeFromGridPane(0, gridSize - 1);
        trail.setBlueLightTrail();
    }

    public void goDown() {
    }

    public void goLeft() {
    }

    public void goRight() {

    }
}
