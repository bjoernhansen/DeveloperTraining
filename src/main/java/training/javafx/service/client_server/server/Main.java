package training.javafx.service.client_server.server;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

import java.util.Objects;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            AnchorPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Server.fxml")));
            Scene scene = new Scene(root, 400, 400);
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
