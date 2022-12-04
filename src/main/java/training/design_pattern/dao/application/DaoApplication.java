package training.design_pattern.dao.application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

import java.util.Objects;


public class DaoApplication extends Application {
	
	private static final String
		FXML_FILE_NAME = "/fxml/dao_application.fxml";
	
	private static final String
		CSS_FILE_NAME = "/css/application.css";
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(FXML_FILE_NAME)));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource(CSS_FILE_NAME))
											  .toExternalForm());
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
