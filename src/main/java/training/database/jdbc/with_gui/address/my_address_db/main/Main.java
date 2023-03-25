package training.database.jdbc.with_gui.address.my_address_db.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Objects;


public class Main extends Application
{
    private static final String
        FXML_FILE_NAME = "/fxml/address/my_address_db.fxml";
    
    private static final String
        CSS_FILE_NAME = "/css/application.css";
    
    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            BorderPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(FXML_FILE_NAME)));
            Scene scene = new Scene(root, 685, 400);
            scene.getStylesheets()
                 .add(Objects.requireNonNull(getClass().getResource(CSS_FILE_NAME))
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
