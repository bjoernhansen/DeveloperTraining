package training.javafx.service.messenger.server;

public class Server
{      
    private final MessageService messageService;

    public Server()
    {
        this.messageService = new MessageService();
    }

    public MessageService getMessageService()
    {
        return this.messageService;
    }
}
