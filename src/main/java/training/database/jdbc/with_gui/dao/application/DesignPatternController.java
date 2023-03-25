package training.database.jdbc.with_gui.dao.application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import training.database.jdbc.with_gui.dao.dao.DesignPatternDAO;
import training.database.jdbc.with_gui.dao.dao.DesignPatternMySQLDAO;
import training.database.jdbc.with_gui.dao.model.DesignPattern;

import java.net.URL;
import java.util.ResourceBundle;


public class DesignPatternController implements Initializable
{
    
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
    public void save(ActionEvent event)
    {
        boolean saved = dao.save(new DesignPattern(inputName.getText(), inputBeschreibung.getText()));
        
        if(saved)
        {
            designPatternTableView.setItems(FXCollections.observableArrayList(dao.findAll()));
        }
    }
    
    @FXML
    public void delete()
    {
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        dao = new DesignPatternMySQLDAO(); //DesignPatternTestDAO();
        designPatternTableView.setItems(FXCollections.observableArrayList(dao.findAll()));
    }
}
