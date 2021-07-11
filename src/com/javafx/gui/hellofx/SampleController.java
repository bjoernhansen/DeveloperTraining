package com.javafx.gui.hellofx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class SampleController {

	@FXML TextField textField;
	@FXML Label label;
	
	
	@FXML public void buttonAction(ActionEvent event) {
		Button b = (Button) event.getSource();
		b.setText("*******");
		label.setText(textField.getText());
	}
	
}
