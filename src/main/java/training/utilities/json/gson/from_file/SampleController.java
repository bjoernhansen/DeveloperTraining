package training.utilities.json.gson.from_file;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class SampleController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField vornameField;

	@FXML
	private TableView<Person> tableView;

	@FXML
	private TextField nachnameField;

	private PersonDAO dao;

	@FXML
	TableColumn<Person, String> vornameCol;

	@FXML
	TableColumn<Person, String> nachnameCol;

	@FXML
	void saveAction(ActionEvent event) {
		dao.savePerson(new Person(vornameField.getText(), nachnameField.getText()));
		tableView.setItems(FXCollections.observableArrayList(dao.findAll()));
	}

	@FXML
	void initialize() {
		dao = new PersonDAO();
		tableView.setItems(FXCollections.observableArrayList(dao.findAll()));
		vornameCol.setCellValueFactory(new PropertyValueFactory<>("vorname"));
		nachnameCol.setCellValueFactory(new PropertyValueFactory<>("nachname"));
	}
}
