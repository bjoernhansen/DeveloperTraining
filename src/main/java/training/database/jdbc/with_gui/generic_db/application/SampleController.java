package training.database.jdbc.with_gui.generic_db.application;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import training.database.jdbc.with_gui.generic_db.db.EntityDAO;
import training.database.jdbc.with_gui.generic_db.model.Entity;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import static training.database.DatabaseAccessData.PREFERRED_TABLE;


public class SampleController implements Initializable
{
    @FXML
    private BorderPane pane;
    @FXML
    private Label infoLabel;
    
    private final EntityDAO dao = new EntityDAO();
    
    

    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        TableView<Entity> tableView = setupTableView();
        for(Entity entity : dao.findAll(PREFERRED_TABLE))
        {
            tableView.getItems()
                     .add(entity);
        }
        infoLabel.setText("Tabelle: " + PREFERRED_TABLE);
        pane.setCenter(tableView);
    }
    
    private TableView<Entity> setupTableView()
    {
        List<String> fieldNames = dao.getFieldNames(PREFERRED_TABLE);
        TableView<Entity> tableView = new TableView<>();
        for(String fieldName : fieldNames)
        {
            TableColumn<Entity, String> col = new TableColumn<>(fieldName);
            tableView.getColumns()
                     .add(col);
            col.setCellValueFactory(param -> new SimpleStringProperty(Optional.ofNullable(param.getValue()
                                                                                               .getFieldValue(fieldName))
                                                                              .orElse("")
                                                                              .toString()));
        }
        return tableView;
    }
}
