package training.javafx.gui.multimedia;

import java.io.File;
import java.util.Objects;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(
					Objects.requireNonNull(getClass().getResource("/css/application.css"))
						   .toExternalForm());

			Media media = new Media(new File("src/main/resources/sounds/chrome_japan.mp4").toURI().toString());
			
			MediaPlayer m = new MediaPlayer(media);
			m.setAutoPlay(true);
			
			MediaView mv = new MediaView(m);
			root.setCenter(mv);
		

			// -------------------

			DoubleProperty width = mv.fitWidthProperty();
			DoubleProperty height = mv.fitHeightProperty();

			width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
			height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));

			//mv.setPreserveRatio(true);
			// ------------------
			Button b = new Button("Full Screen");
			b.setOnAction(event -> {

				// window==MainStage
				primaryStage.setFullScreen(true);

			});

			root.setBottom(b);
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
