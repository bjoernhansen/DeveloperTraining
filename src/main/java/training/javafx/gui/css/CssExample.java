package training.javafx.gui.css;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.Objects;


public class CssExample extends Application {
	@Override
	public void start(Stage primaryStage) {
		try 
		{			
			FlowPane mainPane = new FlowPane();
			Scene scene = new Scene(mainPane,400,400);
			scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/example.css"))
											  .toExternalForm());
			
			Button b1 = new Button("Button1");
			Button b2 = new Button("Button2");
			Button b3 = new Button("Button3");
			b2.getStyleClass().add("myButton");
			b3.setId("b3");
			mainPane.getChildren().add(b1);
			mainPane.getChildren().add(b2);
			mainPane.getChildren().add(b3);
			
			Parent extraView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/extra_view.fxml")));
			mainPane.getChildren().add(extraView);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}