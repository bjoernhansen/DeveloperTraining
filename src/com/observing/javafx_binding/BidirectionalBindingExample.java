package com.observing.javafx_binding;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.text.NumberFormat;


public class BidirectionalBindingExample extends Application {

    private static final double INITIAL_STAND = 0.3;

    @Override
    public void start(Stage primaryStage) {

        Slider slider = new Slider();
        slider.setValue(INITIAL_STAND);
        TextField field = new TextField();
        field.setText(Double.toString(INITIAL_STAND));

        field.textProperty().bindBidirectional(slider.valueProperty(), NumberFormat.getNumberInstance());

        GridPane grid = new GridPane();
        grid.add(slider, 0, 0);
        grid.add(field, 0, 1);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));
        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Binding-Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}