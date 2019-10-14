package com.lemairedev.gui;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class GridFx extends GridPane {
    private int gridSize;
    private SquareFx bluePlayer;
    private SquareFx redPlayer;

    public GridFx() {
        EventHandler<KeyEvent> eventHandler = e -> movePlayer(e);
        this.addEventHandler(KeyEvent.KEY_PRESSED, eventHandler);
    }

    private void movePlayer(KeyEvent e) {
        switch (e.getCode()){
            case UP:
                System.out.println("TEST");;
                bluePlayer = (SquareFx)getNodeFromGridPane(1,gridSize-1);
                bluePlayer.setBluePlayer();
                SquareFx trail = (SquareFx)getNodeFromGridPane(0,gridSize-1);
                trail.setBlueLightTrail();
                break;
            case DOWN:
                break;
            case LEFT:
                break;
            case RIGHT:

        }
    }

    public void createGameGrid(GridPane grid, int size) {
        this.gridSize = size;
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                SquareFx squareFx = new SquareFx(60,60);
                grid.add(squareFx, i, j);
            }
        }
    }

    private void generateWalls(GridPane grid){
        //grid.add(new SquareFx(60,60));
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
        bluePlayer = (SquareFx)getNodeFromGridPane(0,gridSize-1);
        bluePlayer.setBluePlayer();
        redPlayer = (SquareFx)getNodeFromGridPane(gridSize-1,0);
        redPlayer.setRedPlayer();
    }

    public void addWalls(){
        SquareFx wall = (SquareFx)getNodeFromGridPane(5,5);
        SquareFx wall2 = (SquareFx)getNodeFromGridPane(6,5);
        SquareFx wall3 = (SquareFx)getNodeFromGridPane(7,5);
        wall.setWall();
        wall2.setWall();
        wall3.setWall();
    }
}
