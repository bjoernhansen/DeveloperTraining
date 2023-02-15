package training.javafx.service.url_service;

import java.net.MalformedURLException;
import java.net.URL;

import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SampleController
{
	URLService service = new URLService();
	ExtractURLService extractService = new ExtractURLService();

    @FXML
    private TextArea textArea;
    
    @FXML
    private TextArea urlListTextField;

    @FXML
    private Tab textFieldURL;
    
    @FXML
    private Tab browser;

    @FXML
    private ListView<?> listView;

    @FXML
    private TextField urlField;
    
    @FXML
    private Button startButton;

    @FXML
    private Label label_1;
    
    @FXML
    private Label label_2;
        
    @FXML
    void clicked(ActionEvent event) 
    {        
        try 
        {
            service.setUrl(new URL(urlField.getText()));
        } 
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        service.restart();
    }
    
    
    
    
    @FXML
    void initialize() 
    {            
        label_1.textProperty().bind(service.messageProperty()); // updateMessage
        label_2.textProperty().bind(extractService.messageProperty()); // updateMessage
        textArea.textProperty().bind(service.valueProperty());      
        urlListTextField.textProperty().bind(extractService.valueProperty());       
               
        service.setOnSucceeded(new EventHandler<WorkerStateEvent>()
        {               
            @Override
            public void handle(WorkerStateEvent event)
            {                
                extractService.setUrlText(textArea.getText());
                extractService.restart();
            }
        });        
    }
}
