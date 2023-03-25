package training.database.jdbc.with_gui.address.my_address_db.controller;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import training.database.jdbc.with_gui.address.DBConnect;
import training.database.jdbc.with_gui.address.DBConnectException;
import training.database.jdbc.with_gui.address.my_address_db.dao.MySQLPersonDAO;
import training.database.jdbc.with_gui.address.my_address_db.dao.PersonDAO;
import training.database.jdbc.with_gui.address.my_address_db.model.Person;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressController
{
    private PersonDAO dao;
    
    @FXML
    private TableView<Person> personenTableView;
    
    @FXML
    private TableColumn<Person, String> idColumn;
    
    @FXML
    private TableColumn<Person, String> vornameColumn;
    
    @FXML
    private TableColumn<Person, String> nachnameColumn;
    
    @FXML
    private TableColumn<Person, String> plzColumn;
    
    @FXML
    private TableColumn<Person, String> ortColumn;
    
    @FXML
    private TableColumn<Person, String> strasseColumn;
    
    @FXML
    private TableColumn<Person, String> telefonColumn;
    
    @FXML
    private TableColumn<Person, String> mobilColumn;
    
    @FXML
    private TableColumn<Person, String> emailColumn;
    
    @FXML
    private TextField vornameTextfield;
    
    @FXML
    private TextField nachnameTextfield;
    
    @FXML
    private TextField plzTextfield;
    
    @FXML
    private TextField ortTextfield;
    
    @FXML
    private TextField strasseTextfield;
    
    @FXML
    private TextField telefonTextfield;
    
    @FXML
    private TextField mobilTextfield;
    
    @FXML
    private TextField emailTextfield;
    
    @FXML
    private Button speichern;
    
    @FXML
    private Button refresh;
    
    @FXML
    void refreshClicked(ActionEvent event)
    {
        this.updateTableView();
    }
    
    @FXML
    void saveNewPerson(ActionEvent event)
    {
        try
        {
            Connection con = DBConnect.getInstance().getConnection();
            
            Statement insertStatement = con.createStatement();
            
            insertStatement.executeUpdate("INSERT INTO adressen (vorname, nachname, plz, ort, strasse, telefon, mobil, email) VALUES ('"
                + this.vornameTextfield.getText() + "', '"
                + this.nachnameTextfield.getText() + "', '"
                + this.plzTextfield.getText() + "', '"
                + this.ortTextfield.getText() + "', '"
                + this.strasseTextfield.getText() + "', '"
                + this.telefonTextfield.getText() + "', '"
                + this.mobilTextfield.getText() + "', '"
                + this.emailTextfield.getText() + "')");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch(DBConnectException e)
        {
            throw new RuntimeException(e);
        }
        this.updateTableView();
    }
    
    private void deletePerson(int id)
    {
        try
        {
            Connection con = DBConnect.getInstance().getConnection();
            Statement deleteStatement = con.createStatement();
            
            deleteStatement.executeUpdate("DELETE FROM adressen WHERE id = " + id);
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch(DBConnectException e)
        {
            throw new RuntimeException(e);
        }
    
        updateTableView();
    }
    
    @FXML
    void initialize() throws DBConnectException
    {
        this.dao = new MySQLPersonDAO();
        
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        vornameColumn.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        nachnameColumn.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        plzColumn.setCellValueFactory(new PropertyValueFactory<>("plz"));
        ortColumn.setCellValueFactory(new PropertyValueFactory<>("ort"));
        strasseColumn.setCellValueFactory(new PropertyValueFactory<>("strasse"));
        telefonColumn.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        mobilColumn.setCellValueFactory(new PropertyValueFactory<>("mobil"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        vornameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nachnameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //plzColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ortColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        strasseColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        telefonColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        mobilColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        ContextMenu cm = new ContextMenu();
        this.personenTableView.setContextMenu(cm);
        MenuItem delItem = new MenuItem("Delete");
        cm.getItems()
          .add(delItem);
        delItem.setOnAction(e -> {
            deletePerson(this.personenTableView.getSelectionModel()
                                               .getSelectedItem()
                                               .getId());
        });
        
        this.updateTableView();
    }
    
    private void updateTableView()
    {
        this.personenTableView.setItems(FXCollections.observableArrayList(this.dao.findAllPersons()));// ArrayList zu ObservableList
    }
}