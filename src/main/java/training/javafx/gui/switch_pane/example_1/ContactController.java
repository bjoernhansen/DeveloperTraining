package training.javafx.gui.switch_pane.example_1;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ContactController
{
    @FXML
    TextField contactTextField;
    
    public void initialize()
    {
        // TODO Auto-generated method stub
        System.out.println("init");
        contactTextField.setUserData(new Person("Max"));
    }
}
