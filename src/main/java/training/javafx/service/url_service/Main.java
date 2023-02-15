package training.javafx.service.url_service;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

import java.util.Objects;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            BorderPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/urlService.fxml")));
            Scene scene = new Scene(root, 700, 750);
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
