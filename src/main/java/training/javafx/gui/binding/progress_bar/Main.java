package training.javafx.gui.binding.progress_bar;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;

import java.util.Objects;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 400, 400);
            scene.getStylesheets().add(
                    Objects.requireNonNull(getClass().getResource("/css/application.css"))
                           .toExternalForm());
            Button b1 = new Button("+1");
            Button b2 = new Button("-1");
            ProgressBar pb = new ProgressBar();
            Temperature temperature = new Temperature();

            b1.setOnAction(e -> temperature.setGrad(temperature.getGrad() + 0.1F));

            b2.setOnAction(e -> temperature.setGrad(temperature.getGrad() - 0.1F));

            // Binding
            pb.progressProperty().bind(temperature.gradProperty());

            // Listener
            /*
            temperature.gradProperty().addListener((a, oldValue, newValue) -> {
                System.out.println(a.toString());
                System.out.println("Old value: " + oldValue.toString());
                System.out.println("New value: " + newValue.toString());
                
                pb.setProgress(newValue.doubleValue());
            });
            */
            
            root.setTop(b1);
            root.setBottom(b2);
            root.setCenter(pb);
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
