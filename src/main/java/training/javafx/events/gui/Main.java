package training.javafx.events.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application
{
    private TextField tf;
    
    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 400, 400);
            //------------------------------------------
            Button b1 = new Button("B1");
            Button b2 = new Button("B2");
            Button b3 = new Button("B3");
            tf = new TextField();
            
            // Events
            b1.setOnAction(new ButtonAction());// Variante 1 - extra, innere Klasse
            
            b2.setOnAction(new EventHandler<ActionEvent>()
            { // Variante 2 - annonym
                
                @Override
                public void handle(ActionEvent event)
                {
                    Button b = (Button) event.getSource();
                    tf.setText("Hallo " + b.getText());
                    
                }
            });
            
            b3.setOnAction(e -> {  //Variante 3 Funktional -> Lambda-Ausdruck
                Button b = (Button) e.getSource();
                tf.setText("Hallo " + b.getText());
            });
            
            root.setTop(b1);
            root.setBottom(b2);
            root.setRight(b3);
            root.setCenter(tf);
            //-------------------------------------------
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private class ButtonAction implements EventHandler<ActionEvent>
    { // auch als externe Klasse
        @Override
        public void handle(ActionEvent event)
        {
            Button b = (Button) event.getSource();
            tf.setText("Hallo " + b.getText());
            
        }
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
