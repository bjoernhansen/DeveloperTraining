package training.javafx.service.messenger.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import training.javafx.service.messenger.model.MessageObject;
import training.javafx.service.messenger.ui.Main;

import static training.javafx.service.messenger.server.MessageService.PORT;


public class Client
{        
    private String serverhost;

    // Socket und Outputstream erzeugen und Nachricht schreiben
    public void writeMSG(MessageObject msgObj)
    {        
        try(Socket socket = new Socket(this.serverhost, PORT))
        {                                                   
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(msgObj); 
        }
        catch (IOException e)
        {
            Main.log.error("Could not write message!");
            e.printStackTrace();
        }
    }
    
    public void setServerhost(String serverhost)
    {
        this.serverhost = serverhost;
    }
}
