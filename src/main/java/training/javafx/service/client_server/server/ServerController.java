package training.javafx.service.client_server.server;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class ServerController
{
    Server server= new Server();
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label serverMessageLabel;

    @FXML
    private Label serverActiveLabel;
    
    @FXML
    void serverStart(ActionEvent event)
    { 
        server.restart();        
        serverActiveLabel.setTextFill(Color.GREEN);
        serverActiveLabel.setText("SERVER ON");
    }
    
    
    @FXML
    void initialize() 
    {       
        server.setServerSocket(1234);     
        serverMessageLabel.setText("Hello!");
        serverMessageLabel.textProperty().bind(server.valueProperty());
               
        server.setOnSucceeded(event -> {

        });
    }
    
}
