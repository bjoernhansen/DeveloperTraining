package com.javafx.gui.menue;

import java.io.File;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.DirectoryChooser;

public class SampleController {

	@FXML public void openAction(ActionEvent event) {
		
		DirectoryChooser dc = new DirectoryChooser();
		File file = dc.showDialog(null);
		
		if(file!=null) {
			System.out.println(file.getAbsolutePath());
		}
	}

	@FXML public void exitAction(ActionEvent event) {
		
		Platform.exit();
	}
	
}
