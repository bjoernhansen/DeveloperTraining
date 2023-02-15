package training.javafx.service.messenger.ui;

import javafx.scene.layout.AnchorPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application
{
    public static Logger log = LogManager.getRootLogger();

    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Messenger.fxml")));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/application.css"))
                                              .toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
