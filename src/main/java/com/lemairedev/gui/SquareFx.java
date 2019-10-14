package com.lemairedev.gui;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class SquareFx extends Rectangle {

    //private Square square;


    public SquareFx(double width, double height) {
        super(width, height);
        //this.square = new Square();
        this.setFill(Color.LIGHTGRAY);
        this.setStroke(Color.DARKGRAY);
        this.setStrokeWidth(2);

        EventHandler<MouseEvent> eventHandler = e -> changeColor();
        this.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    public void changeColor(){
        this.setStroke(Color.RED);
    }

    public void setBluePlayer(){
        Image player = new Image("/images/bluecar.png");
        this.setFill(new ImagePattern(player));
    }

    public void setBlueLightTrail(){
        this.setFill(Color.LIGHTGRAY);
        this.setStroke(Color.BLUE);
    }

    public void setRedLightTrail(){
        this.setStroke(Color.RED);
        this.setFill(Color.LIGHTGRAY);
    }

    public void setDefault(){
        this.setFill(Color.LIGHTGRAY);
        this.setStroke(Color.DARKGRAY);
    }

    public void setRedPlayer(){
        Image player = new Image("/images/redcar.png");
        this.setFill(new ImagePattern(player));
    }

    public void setWall(){
        Image wall = new Image("/images/wall.png");
        this.setFill(new ImagePattern(wall));
    }
}
