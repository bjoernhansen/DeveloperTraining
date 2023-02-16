package training.javafx.gui.switch_pane.example_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;


public class View2Controller implements Initializable
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
        Scene scene = label.getScene();
        Pane cPane = (Pane) scene.lookup("#content");
        BorderPane mainPane = (BorderPane) cPane.getParent();
        mainPane.setBottom(new Button("einer neuer Button auf dem Root-Pane..."));
    }
}
