package training.javafx.gui.views.list;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import training.javafx.gui.views.helper.Car;


public class SampleController
{
    @FXML
    private ListView<Car> listView;
    
    @FXML
    private Label label;
    
    
    @FXML
    void initialize()
    {
        listView.getItems()
                .add(new Car(1999, "BMW"));
        listView.getItems()
                .add(new Car(2003, "Ford"));
        listView.getItems()
                .add(new Car(2009, "Opel"));
        
        
        listView.setCellFactory(lv -> new MyListCell());
        
        listView.getSelectionModel()
                .selectedItemProperty()
                .addListener((a, b, newValue) -> {
            
                    label.setText(newValue.getMake() + " " + newValue.getYear());
                });
    }
    
    class MyListCell extends ListCell<Car>
    {
        @Override
        protected void updateItem(Car item, boolean empty)
        {
            super.updateItem(item, empty);
            if(item != null)
            {
                setText(item.getMake());
            }
        }
    }
}
