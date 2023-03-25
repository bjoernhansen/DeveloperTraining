package training.database.jdbc.with_gui.simple;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

import java.util.Objects;

/**
 * dynamische Tabelle mit Insert und Update
*
*	Java 1
* 	@author Dozent: Micha Schirmer
*	@11.02.2015
*	@d_fx_DynamicEditTable
*
 */

public class Main extends Application {
	// TODO zusammenführen mit jdbc/with_gui/dao
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/table_view_3.fxml")));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/application.css"))
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
