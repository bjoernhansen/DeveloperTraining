package training.database.jdbc.with_gui.address.address_part4.controller;


import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Duration;
import training.database.jdbc.with_gui.address.address_part4.dao.MySQLPersonDAO;
import training.database.jdbc.with_gui.address.address_part4.dao.PersonDAO;
import training.database.jdbc.with_gui.address.DBConnectException;
import training.database.jdbc.with_gui.address.address_part4.model.Person;


public class AddressController
{
    @FXML
    private TableView<Person> adressTableView;
    
    @FXML
    private TableColumn<Person, Integer> idCol;
    
    @FXML
    private TableColumn<Person, String> vornameCol;
    
    @FXML
    private TableColumn<Person, String> nachnameCol;
    
    @FXML
    private TableColumn<Person, String> plzCol;
    
    @FXML
    private TableColumn<Person, String> ortCol;
    
    @FXML
    private TableColumn<Person, String> strasseCol;
    
    @FXML
    private TableColumn<Person, String> telefonCol;
    
    @FXML
    private TableColumn<Person, String> mobilCol;
    
    @FXML
    private TableColumn<Person, String> emailCol;
    
    @FXML
    private TextField vornameFiled;
    
    @FXML
    private TextField nachnameField;
    
    @FXML
    private TextField plzField;
    
    @FXML
    private TextField ortField;
    
    @FXML
    private TextField strasseField;
    
    @FXML
    private TextField telfonField;
    
    @FXML
    private TextField mobilField;
    
    @FXML
    private TextField emailField;
    
    @FXML
    private Label infoLabel;
    // -----------------Member
    
    private PersonDAO dao;
    
    @FXML
    void saveAction(ActionEvent event)
    {
        boolean saved = this.dao.savePerson(
            new Person(this.vornameFiled.getText(), this.nachnameField.getText(), this.ortField.getText(), this.plzField.getText(),
                this.strasseField.getText(), this.telfonField.getText(), this.mobilField.getText(), this.emailField.getText()));
        
        System.out.println("saved? " + saved);
        if(saved)
        {
            setInfoText("Datensatz gespeichert!");
        }
    }
    
    @FXML
    void initialize()
    {
        try
        {
            System.out.println("Controller.initialize");//log:debug
            this.dao = new MySQLPersonDAO();
            
            System.out.println("Controller.new MySQLPersonDAO: " + this.dao);//log:debug
            
            setupPersonTableView();
            setupTabelViewContextMenu();
            refresh();
        }
        catch(DBConnectException e)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("Fehler bei der Verbindung mit der Datenbank, bitte DB erbinden und Neustart");
            alert.showAndWait();
            Platform.exit();
        }
    }
    
    /*
     * Events
     */
    @FXML
    public void refreshAction(ActionEvent event)
    {
        refresh();
        
    }
    
    /*
     * update
     */
    @FXML
    public void onEditCommit(CellEditEvent<Person, String> c)
    {
        String newValue = c.getNewValue();
        System.out.println("commit.newValue: " + newValue);
        Person p = c.getRowValue();
        String dbField = c.getTableColumn()
                          .getId();
        
        System.out.println("commit.dbfield: " + dbField);
        boolean updated = this.dao.updatePerson(p.getId(), dbField, newValue);
        if(updated)
        {
            setInfoText("Upadate erfolgreich: " + c.getTableColumn()
                                                   .getText() + ", id: " + p.getId());
        }
    }
    
    private void setupTabelViewContextMenu()
    {
        // ContextMenu
        ContextMenu cm = new ContextMenu();
        
        MenuItem deleteItem = new MenuItem("Delete");
        deleteItem.setOnAction(e -> {// TODO evtl. auslagern
            Person p = this.adressTableView.getSelectionModel()
                                           .getSelectedItem();// .getSelectedItems();
            System.out.println(p);
            boolean deleted = this.dao.deletePerson(p.getId());
            if(deleted)
            {
                setInfoText("Datensatz mit der Id " + p.getId() + " gelöscht!");
                this.adressTableView.getItems()
                                    .remove(p);
            }
            
        });
        cm.getItems()
          .add(deleteItem);
        this.adressTableView.setContextMenu(cm);
    }
    
    private void setupPersonTableView()
    {
        // oder im FXML
        this.idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.vornameCol.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        this.nachnameCol.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        this.plzCol.setCellValueFactory(new PropertyValueFactory<>("plz"));
        this.ortCol.setCellValueFactory(new PropertyValueFactory<>("ort"));
        this.strasseCol.setCellValueFactory(new PropertyValueFactory<>("strasse"));
        this.telefonCol.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        this.mobilCol.setCellValueFactory(new PropertyValueFactory<>("mobil"));
        this.emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        this.emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        this.telefonCol.setCellFactory(TextFieldTableCell.forTableColumn());
        this.mobilCol.setCellFactory(TextFieldTableCell.forTableColumn());
    }
    
    private void setInfoText(String msg)
    {
        FadeTransition ft = new FadeTransition(Duration.seconds(3), this.infoLabel);
        ft.setFromValue(1);// 100%
        ft.setToValue(0);
        ft.setDelay(Duration.seconds(1));
        ft.play();
        this.infoLabel.setText(msg);
    }
    
    private void refresh()
    {
        this.adressTableView.setItems(FXCollections.observableArrayList(this.dao.findAllPersons()));// ArrayList zu ObservableList
    }
}
