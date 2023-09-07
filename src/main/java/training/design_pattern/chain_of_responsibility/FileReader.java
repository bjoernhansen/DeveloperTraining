package training.design_pattern.chain_of_responsibility;


public abstract class FileReader
{
    private final FileReader
        next;

    private boolean
        wasFileRead = false;


    public FileReader(FileReader next)
    {
        this.next = next;
    }

    void read(String filename)
    {
        tryToRead(filename);
        if(!wasFileRead && next != null)
        {
            next.read(filename);
        }
    }

    abstract void tryToRead(String filename);

    void markAsRead()
    {
        wasFileRead = true;
    }
}
