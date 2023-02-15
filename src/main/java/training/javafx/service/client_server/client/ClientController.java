package training.javafx.service.client_server.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ClientController
{
    Client client = new Client();    
    
    @FXML
    private TextField messageTextField;

    @FXML
    void writeAction(ActionEvent event)
    {       
        client.setText(messageTextField.getText());
        client.restart();
    }

    @FXML
    void initialize()
    {

    }
}
