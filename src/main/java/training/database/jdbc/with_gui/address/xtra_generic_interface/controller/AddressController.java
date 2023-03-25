package training.database.jdbc.with_gui.address.xtra_generic_interface.controller;


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
import training.database.jdbc.with_gui.address.DBConnectException;
import training.database.jdbc.with_gui.address.xtra_generic_interface.dao.MySQLPersonDAO;
import training.database.jdbc.with_gui.address.xtra_generic_interface.dao.PersonDAO;
import training.database.jdbc.with_gui.address.xtra_generic_interface.model.Person;

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
    
    private PersonDAO<Person> dao;
    
    @FXML
    void saveAction(ActionEvent event)
    {
        boolean saved = dao.save(
            new Person(vornameFiled.getText(), nachnameField.getText(), ortField.getText(), plzField.getText(),
                strasseField.getText(), telfonField.getText(), mobilField.getText(), emailField.getText()));
        
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
            dao = new MySQLPersonDAO();
            
            System.out.println("Controller.new MySQLPersonDAO: " + dao);//log:debug
            
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
        catch(Exception e)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("Fehler");
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
                          .getId();//  <TableColumn id="mobil"
        
        System.out.println("commit.dbfield: " + dbField);
        boolean updated = dao.update(p.getId(), dbField, newValue);
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
            Person p = adressTableView.getSelectionModel()
                                      .getSelectedItem();// .getSelectedItems();
            System.out.println(p);
            boolean deleted = dao.delete(p.getId());
            if(deleted)
            {
                setInfoText("Datensatz mit der Id " + p.getId() + " gelöscht!");
                adressTableView.getItems()
                               .remove(p);
            }
            
        });
        cm.getItems()
          .add(deleteItem);
        adressTableView.setContextMenu(cm);
    }
    
    private void setupPersonTableView()
    {
        // oder im FXML
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        vornameCol.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        nachnameCol.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        plzCol.setCellValueFactory(new PropertyValueFactory<>("plz"));
        ortCol.setCellValueFactory(new PropertyValueFactory<>("ort"));
        strasseCol.setCellValueFactory(new PropertyValueFactory<>("strasse"));
        telefonCol.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        mobilCol.setCellValueFactory(new PropertyValueFactory<>("mobil"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        telefonCol.setCellFactory(TextFieldTableCell.forTableColumn());
        mobilCol.setCellFactory(TextFieldTableCell.forTableColumn());
    }
    
    private void setInfoText(String msg)
    {
        FadeTransition ft = new FadeTransition(Duration.seconds(3), infoLabel);
        ft.setFromValue(1);// 100%
        ft.setToValue(0);
        ft.setDelay(Duration.seconds(1));
        ft.play();
        infoLabel.setText(msg);
    }
    
    private void refresh()
    {
        adressTableView.setItems(FXCollections.observableArrayList(dao.findAll()));// ArrayList zu ObservableList
    }
}
