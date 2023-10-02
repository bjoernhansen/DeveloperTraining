package training.design_pattern.observer.javafx_binding.gui_example;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

import java.awt.*;


public class EllipsePainter extends Application
{
    private final DoubleProperty centerX = new SimpleDoubleProperty(100);

    private final DoubleProperty centerY = new SimpleDoubleProperty(300);


    private final Ellipse ellipse = new Ellipse(100, 300, 75, 125);


    @Override
    public void start(final Stage primaryStage)
    {
        ellipse.centerXProperty().bind(centerX);
        ellipse.centerYProperty().bind(centerY);




        Canvas canvas = new Canvas(1000, 1000);


        canvas.setOnMouseClicked(this::mouseClickEvent);


        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY))); // Setze den Hintergrund auf Rot
        anchorPane.getChildren().add(canvas);


        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);


        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setFullScreen(true);
        primaryStage.show();


        GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();


        new AnimationTimer()
        {
            @Override
            public void handle(long now)
            {
                graphicsContext2D.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                graphicsContext2D.setFill(Color.RED);
                graphicsContext2D.fillOval(
                    ellipse.getCenterX() - ellipse.getRadiusX(),
                    ellipse.getCenterY() - ellipse.getRadiusY(),
                    2 * ellipse.getRadiusX(),
                    2 * ellipse.getCenterY());
            }
        }.start();
    }

    private void mouseClickEvent(MouseEvent event)
    {
        printPosition("old ellipse position", ellipse.getCenterX(), ellipse.getCenterY());

        centerX.set(event.getX());
        centerY.set(event.getY());

        printPosition("new ellipse position", ellipse.getCenterX(), ellipse.getCenterY());
    }

    private void printPosition(String name, double x, double y)
    {
        System.out.println(name + ": " + x + " " + y);
    }

    public static void main(String[] args)
    {
        Application.launch(EllipsePainter.class);
    }
}
