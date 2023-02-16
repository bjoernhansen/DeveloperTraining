package training.javafx.gui.views.table.example_1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;

public class SampleController implements Initializable{
	
	private ObservableList<Person> oList;
	@FXML
	private TableView<Person> personTableView;
	@FXML
	private TextField inputVorname;
	@FXML
	private TextField inputNachname;
	@FXML
	private DatePicker inputDate;
	
	
	@FXML
	private TableColumn<Person,String> vornameColumn;

	@FXML 
	private TableColumn<Person,String> nachnameColumn;

	// Event Listener on Button.onAction
	@FXML
	public void save() {
		int newId= this.personTableView.getColumns().size()+1;
		this.oList.add(new Person(this.inputVorname.getText(), this.inputNachname.getText(), this.inputDate.getValue(), newId));
	}

	
	
	@FXML
	public void editCommit(CellEditEvent<Person, String> ce){
		
		System.out.println("Commit");
		System.out.println("newValue: "+ ce.getNewValue());
	}
	
	@FXML
	public void editStart(){
		System.out.println("start");
	}
	
	@FXML
	public void editCancel(){
		System.out.println("cancel");
	}
	
	@FXML
	public void delete(){
		this.oList.remove(this.personTableView.getSelectionModel().getSelectedItem());
	}
		
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{		
		ContextMenu cm = new ContextMenu();
		this.personTableView.setContextMenu(cm);
		MenuItem delItem = new  MenuItem("Delete");
		cm.getItems().add(delItem);
		delItem.setOnAction(e -> {
			Person p = this.personTableView.getSelectionModel().getSelectedItem();
			this.oList.remove(p);
		});
		
		

		PersonList pList = new PersonList();
		this.oList = FXCollections.observableArrayList(pList.getPersonList());

		this.personTableView.setItems(this.oList);
		
		
		// Edtitabe
		this.vornameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		this.nachnameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		//<cellValueFactory><PropertyValueFactory property="id" />

		// alternativ zum FXML
		//vornameColumn.setCellValueFactory(new PropertyValueFactory<>("id")); //getId()
		 //vornameColumn.setCellValueFactory(new PropertyValueFactory<>("vorname")); getName()
		
	
	}

}
