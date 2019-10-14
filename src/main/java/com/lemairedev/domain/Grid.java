package com.lemairedev.domain;

public class Grid {
    private int size;
    private Square[][] squares;

    public Grid(int size) {
        this.size = size;
        squares = new Square[size][size];
        createSquaresForGrid();
    }

    private Square[][] createSquaresForGrid() {
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                squares[row][column] = new Square(new Coordinates(row, column));
            }
        }
        return squares;
    }

    public int getSize() {
        return size;
    }
}
