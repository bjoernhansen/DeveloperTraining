package training.javafx.gui.hellofx2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SampleController {

    @FXML
    private TextField textField;

    @FXML
    private Label label;

    @FXML
    void buttonAction(ActionEvent event) {
    	label.setText(textField.getText());
    }

}
