package com.javafx.gui.controls;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

public class SampleController implements Initializable{

	@FXML TilePane tilePane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		for (int i = 0; i < 20; i++) {
			Button b = new Button("B"+i);
			b.setOnAction((e)-> System.out.println(e.getSource()));
			
			tilePane.getChildren().add(b);
			
		}
		
	}
	
	

	
}
