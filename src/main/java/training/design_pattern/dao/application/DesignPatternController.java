package training.design_pattern.dao.application;

import java.net.URL;
import java.util.ResourceBundle;

import training.design_pattern.dao.dao.DesignPatternDAO;
import training.design_pattern.dao.dao.DesignPatternTestDAO;
import training.design_pattern.dao.model.DesignPattern;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class DesignPatternController implements Initializable {

	@FXML
	private TableView<DesignPattern> designPatternTableView;
	@FXML
	private TextField inputName;
	@FXML
	private TextField inputBeschreibung;

	
	private DesignPatternDAO dao;

	@FXML
	private TableColumn<DesignPattern, String> vornameColumn;

	// Event Listener on Button.onAction
	@FXML
	public void save(ActionEvent event) {
		
		boolean saved = dao.save(new DesignPattern(inputName.getText(), inputBeschreibung.getText()));

		if(saved) {
			designPatternTableView.setItems(FXCollections.observableArrayList(dao.findAll()));
		}
	}

	@FXML
	public void delete() {
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dao = new DesignPatternTestDAO();
		designPatternTableView.setItems(FXCollections.observableArrayList(dao.findAll()));
	}

}
