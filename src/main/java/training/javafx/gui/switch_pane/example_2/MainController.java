package training.javafx.gui.switch_pane.example_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class MainController implements Initializable
{
    @FXML
    Pane content;
    
    @FXML
    Label label1;
    
    @FXML
    private void showView2()
    {
        try
        {
            System.out.println("content" + content);
            content.getChildren()
                   .clear();
            Pane p = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/switch_pane_view_2.fxml")));
            label1 = (Label) p.lookup("#label1");
            content.getChildren()
                   .add(p);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void showView3()
    {
        try
        {
            content.getChildren()
                   .clear();
            content.getChildren()
                   .add(
                       FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/switch_pane_view_3.fxml"))));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        // TODO Auto-generated method stub
        System.out.println("init MainController");
        
    }
    
    @FXML
    public void delete()
    {
        content.getChildren()
               .clear();
    }
}
