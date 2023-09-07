package training.design_pattern.chain_of_responsibility;

public class QuickBookReader extends FileReader
{
    public QuickBookReader(FileReader next)
    {
        super(next);
    }

    @Override
    void tryToRead(String filename)
    {
        if (filename.endsWith(".qbw")) {
            System.out.println("Reading data from a QuickBooks file.");
            markAsRead();
        }
        else
        {
            System.out.println("failed read file as QuickBooks file");
        }
    }
}
