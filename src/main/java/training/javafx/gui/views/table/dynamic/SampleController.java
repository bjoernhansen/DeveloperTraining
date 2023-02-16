package training.javafx.gui.views.table.dynamic;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import training.javafx.gui.views.helper.Car;

import java.net.URL;
import java.util.ResourceBundle;


public class SampleController implements Initializable
{
    @FXML
    private BorderPane pane;
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        TableView<Car> tableView = new TableView<>();
        for(int i = 1; i <= 5; i++)
        {
            TableColumn<Car, String> col = new TableColumn<>("Col " + i);
            tableView.getColumns()
                     .add(col);
        }
        pane.setCenter(tableView);
    }
}
