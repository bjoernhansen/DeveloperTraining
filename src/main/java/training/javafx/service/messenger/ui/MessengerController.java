package training.javafx.service.messenger.ui;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import training.javafx.service.messenger.client.Client;
import training.javafx.service.messenger.model.MessageObject;
import training.javafx.service.messenger.server.Server;


public class MessengerController implements Initializable
{
    @FXML
    private TextField localServerTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField messageTextField;
    @FXML
    private TextField toServerTextField;
    @FXML
    private TableView<MessageObject> messageTableView;

    // ----------------------- Member---------------------------

    private Client client;
    private Server server;
    private final ObservableList<MessageObject> messageList = FXCollections
            .observableArrayList();

    // Event Listener on Button.onAction
    @FXML
    public void serverStartAction(ActionEvent event)
    {
        System.out.println("serverStartAction");
        Main.log.info("serverStartAction");
        
        this.server.getMessageService().setServerSocket();     
        this.server.getMessageService().serverBind(this.localServerTextField.getText());                
        
        // Server starten in einem Task-Thread
        this.server.getMessageService().restart();
    }

    // Event Listener on Button.onAction
    @FXML // nachricht senden und der Liste anhängen
    public void messageSendAction(ActionEvent event)
    {
        if(    !this.messageTextField.getText().equals("") 
            && !this.nameTextField.getText().equals(""))
        {
            System.out.println("messageSendAction");
            Main.log.info("messageSendAction");
            
            MessageObject msgObj = new MessageObject(
                                        this.nameTextField.getText(), 
                                        this.messageTextField.getText(), 
                                        LocalTime.now());
            
            this.messageList.add(msgObj);
            this.client.writeMSG(msgObj);
            
            this.messageTextField.setText(""); 
        }
    }

    // Event Listener on Button.onAction
    @FXML // Client setzt Serverhost
    public void connectToServerAction(ActionEvent event)
    {
        System.out.println("connectToServerAction");
        this.client.setServerhost(this.toServerTextField.getText());
    }

    // Server und Client erzeugen
    // Listener für die empfangene
    // Nachricht an die Liste hängen
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        this.client = new Client();       
        this.server = new Server();        
                
        this.server.getMessageService().valueProperty().addListener((observableValue,oldValue,newValue)->
        {
            if(newValue != null)
            {
                this.messageList.add(new MessageObject(newValue.getName(), newValue.getMessage(), newValue.getTime()));
            }
        });        
        this.messageTableView.setItems(this.messageList);
    }
}
