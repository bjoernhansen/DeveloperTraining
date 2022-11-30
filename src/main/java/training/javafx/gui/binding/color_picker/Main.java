package training.javafx.gui.binding.color_picker;

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
            BorderPane root = FXMLLoader
                    .load(Objects.requireNonNull(getClass().getResource("Sample.fxml")));
            Scene scene = new Scene(root, 400, 400);
            scene.getStylesheets().add(
                    Objects.requireNonNull(getClass().getResource("application.css"))
                           .toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
