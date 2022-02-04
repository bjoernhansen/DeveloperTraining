package com.javafx.gui.resize_event;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SampleController {

	@FXML BorderPane rootPane;
	
	
	@FXML void initialize(){
		Platform.runLater(()->{
			
			Stage st = (Stage) rootPane.getScene().getWindow();
			
			st.widthProperty().addListener((obs, oldVal, newVal) -> System.out.println(newVal));
			
			st.heightProperty().addListener((obs, oldVal, newVal) -> System.out.println(newVal));
			
			
			
		});
		
	}
	
}
