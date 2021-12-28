package com.javafx.gui.textfield_and_label;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SampleController {



    @FXML
    private TextField textField;

    @FXML
    private Label label;

    @FXML
    void buttonAction(ActionEvent event) {
    	Button b = (Button) event.getSource();
    	if (b.getId().equals("B1")) {
			label.setText(textField.getText());
		}else if(b.getId().equals("B2")) {
			label.setText("");
			textField.setText("");
		}

    }

    @FXML
    void initialize() {

    }
}
