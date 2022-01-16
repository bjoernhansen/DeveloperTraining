package com.javafx.gui.new_window;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Window2Controller {
	@FXML
	private TextField textField;

	// Event Listener on Button.onAction
	@FXML
	public void sendAction(ActionEvent event) {
		MainController maincontroller = (MainController) textField.getScene().getUserData();
		
		maincontroller.getMainLabel().setText(textField.getText());
	}
}
