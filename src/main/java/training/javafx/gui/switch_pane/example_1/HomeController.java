package training.javafx.gui.switch_pane.example_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class HomeController
{
    @FXML
    AnchorPane pane;
    
    @FXML
    public void buttonAction()
    {
        //Zugriff auf ein benachbartes Textfield (Contact.fxml)
        TextField node = (TextField) pane.getParent()
                                         .getParent()
                                         .lookup("#contactTextField");
        System.out.println(node.getText());
        
        //Zugriff auf Daten aus dem anderen Controller (ContactController)
        System.out.println(node.getUserData());
    }
}
