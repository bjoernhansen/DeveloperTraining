package com.javafx.gui.table_view;

import java.net.URL;
import java.sql.SQLOutput;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SampleController implements Initializable{

	@FXML
	private TableView<Designpattern> tableView;
	
	@FXML
	private Button addDesignPatternButton;
	
	@FXML
	private TextField nameTextField;
	
	@FXML
	private TextField descriptionTextField;
	
	private ObservableList<Designpattern> dList;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dList = FXCollections.observableArrayList();
		//ObservableList<Designpattern> dList = FXCollections.observableArrayList(NORMALE_COLLECTION); z.B. ArrayList
		
		dList.add(new Designpattern("Singleton", "nur eine Instanz möglich"));
		dList.add(new Designpattern("MVC", "Trennung Daten von Model"));
		dList.add(new Designpattern("DAO", "Data Access Object: Datenbank Methoden"));
		
		tableView.setItems(dList);
		tableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
            System.out.print("\nobservableValue: ");
            System.out.print(observableValue);
		    System.out.print("\noldValue: ");
		    Optional.ofNullable(oldValue).ifPresent(System.out::print);
            System.out.print("\nnewValue: ");
		    System.out.println(newValue);
		});
	}
	
	public void handleComboBoxAnimalSelectionEvent(ActionEvent actionEvent)
	{
		dList.add(new Designpattern(nameTextField.getText(), descriptionTextField.getText()));
	}
}
