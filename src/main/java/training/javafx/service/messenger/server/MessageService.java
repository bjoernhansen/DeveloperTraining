package training.javafx.service.messenger.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import training.javafx.service.messenger.model.MessageObject;
import training.javafx.service.messenger.ui.Main;


public class MessageService extends Service<MessageObject>
{
    public static final int PORT = 1111;
    
    ServerSocket serverSocket;

    @Override
    protected Task<MessageObject> createTask()
    {
        return new Task<>()
        {
            @Override
            protected MessageObject call()
            {
                updateMessage("MessageService: call");
                // ObjectInputstream erzeugen, Nachricht lesen, zurückgeben
    
                try
                {
                    while(true)
                    {
                        Socket clientSocket = MessageService.this.serverSocket.accept();
                        System.out.println("Server accept...");
                        ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                        MessageObject message = (MessageObject) in.readObject();
                        System.out.println("Empfangener Text: " + message.getMessage());
                        updateValue(message);
    
                        this.cancel();
    
                        if(super.isCancelled())
                        {
                            break;
                        }
                    }
                } catch(Exception e)
                {
                    e.printStackTrace();
                }
                return null;
            }
        };
    }   
    
    public void setServerSocket()
    {        
        try
        {
            // Wenn im Netzwerk genutzt, dann wieder hier den Port setzen und das Binden raus.
            // Wenn es zwei unterschiedliche Rechner sind, gibt es keine Probleme mit der IP.
            // Dann: this.serverSocket = new ServerSocket(PORT);
            this.serverSocket = new ServerSocket();
            
        }
        catch (IOException e)
        {
            Main.log.error(e.fillInStackTrace());
        }
    }
    
    // Server binden: serverSocket.bind(new InetSocketAddress(localIP, 1111));
    // Clientsocket erzeugen(holen), auf Message warten und
    // MessageService starten
    
    public void serverBind(String localhost)
    {
        try
        {
            // bei Netzwerbetrieb die folgende Zeile streichen
            this.serverSocket.bind(new InetSocketAddress(localhost, PORT));
            Main.log.info("ServerSocket bound: " + this.serverSocket.isBound());
        }
        catch (IOException e)
        {            
            e.printStackTrace();
        }
    }    
}
