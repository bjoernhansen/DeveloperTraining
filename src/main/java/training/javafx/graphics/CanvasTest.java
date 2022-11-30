package training.javafx.graphics;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CanvasTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root, 500, 500, Color.BLACK);

			// ---Canvas
			 Canvas canvas = new Canvas(500, 500);
			GraphicsContext gc = canvas.getGraphicsContext2D();
			gc.setFill(Color.RED);
			gc.fillRect(20, 20, 400, 400);

			canvas.setOnMousePressed(event -> {
				gc.setFill(Color.LIGHTGRAY);
				gc.setStroke(Color.GREEN);
				gc.setLineWidth(5);
				
				gc.beginPath();
			
				gc.moveTo(event.getX(), event.getY());
				gc.stroke();
			});
			canvas.setOnMouseDragged(event -> {
				System.out.println(event.getX());
				gc.lineTo(event.getX(), event.getY());
				gc.stroke();
			});
			root.getChildren().add(canvas);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
