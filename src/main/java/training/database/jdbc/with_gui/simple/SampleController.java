package training.database.jdbc.with_gui.simple;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import training.database.DatabaseAccessData;

import static training.database.DatabaseAccessData.CIMDATA_DATABASE;
import static training.database.DatabaseAccessData.PASSWORD;
import static training.database.DatabaseAccessData.USER;

public class SampleController implements Initializable
{	
	private ObservableList<DesignPattern> oList;
	@FXML
	private TableView<DesignPattern> designpatternTableView;
	@FXML
	private TextField inputName;
	@FXML
	private TextField inputBeschreibung;
		
	
	@FXML
	TableColumn<DesignPattern,String> vornameColumn;

	// Event Listener on Button.onAction
	
	@FXML	
	public void save(ActionEvent event) 
	{		
		try 
		{
			Connection con = DriverManager.getConnection(DatabaseAccessData.URL + CIMDATA_DATABASE, USER, PASSWORD);
			Statement insertStatement = con.createStatement();	
						
			insertStatement.executeUpdate("INSERT INTO designpattern (name, beschreibung) VALUES ('"
											+ this.inputName.getText() +  "', '" 
											+ this.inputBeschreibung.getText() + "')");
		} 
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
				
		updateTableView();
	}
	
	private void updateTableView()
	{
		DesignPatternList dList = new DesignPatternList();
		this.oList = FXCollections.observableArrayList(dList.getDesignpatternList());
		this.designpatternTableView.setItems(this.oList);
	}

	@FXML
	public void editCommit(){
		System.out.println("Commit");
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
	public void delete()
	{			
		try {
			Connection con = DriverManager.getConnection(DatabaseAccessData.URL + CIMDATA_DATABASE, USER, PASSWORD);
			Statement deleteStatement = con.createStatement();			
			
			deleteStatement.executeUpdate(	"DELETE FROM designpattern WHERE id = " 
											+ this.designpatternTableView.getSelectionModel().getSelectedItem().getId());
		} 
		catch (SQLException e)
		{			
			e.printStackTrace();
		}
				
		updateTableView();		
	}
		
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		updateTableView();
	}
}
