package com.lemairedev;

import com.lemairedev.gui.GridFx;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RowdyRacersApplication extends Application {
    private static Stage stage;
    private GridFx grid = new GridFx();
    private VBox root = new VBox();
    private HBox header = new HBox();

    @Override
    public void start(Stage stage) throws Exception {
        RowdyRacersApplication.stage = stage;
        stage.setTitle("Rowdy Racers");
        showLauncher(stage);
        stage.show();
    }


    @FXML
    private void startButtonClicked(ActionEvent event) throws FileNotFoundException {
        Spinner<Integer> spinner = (Spinner<Integer>)stage.getScene().lookup("#gridSizeSpinner");
        int gridSize = spinner.getValue();
        grid.createGameGrid(this.grid,gridSize);
        grid.addCars();
        grid.addWalls();

        grid.setAlignment(Pos.CENTER);
        header.getChildren().add(setLogo());
        root.getChildren().add(header);
        root.getChildren().add(grid);
        root.setAlignment(Pos.CENTER);
        root.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        stage.setScene(new Scene(root));
    }



    private void showLauncher(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/launcher.fxml"));
        Parent content = loader.load();
        Scene scene = new Scene(content);
        stage.setScene(scene);

    }

    private ImageView setLogo() throws FileNotFoundException {
        Image logo = new Image("/images/rowdy_racers.png");
        ImageView logoView = new ImageView(logo);
        logoView.setFitHeight(80);
        logoView.setPreserveRatio(true);
        return logoView;
    }

}
