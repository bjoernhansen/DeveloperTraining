package training.database.jdbc.with_gui.generic_db.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Objects;


public class Main extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            BorderPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/table_view_db.fxml")));
            Scene scene = new Scene(root);
            scene.getStylesheets()
                 .add(Objects.requireNonNull(getClass().getResource("/css/application.css"))
                             .toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
