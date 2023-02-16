package training.javafx.gui.switch_pane.example_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;


public class View3Controller implements Initializable
{
    @FXML
    Label label;
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        // TODO Auto-generated method stub
    }
    
    @FXML
    public void action()
    {
        label.setText("Hallo...");
    }
}
