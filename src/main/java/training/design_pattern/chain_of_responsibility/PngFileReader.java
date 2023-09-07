package training.design_pattern.chain_of_responsibility;

public class PngFileReader extends FileReader
{
    public PngFileReader(FileReader next)
    {
        super(next);
    }

    @Override
    void tryToRead(String filename)
    {
        if (filename.endsWith(".png")) {
            System.out.println("Reading data from PNG file.");
            markAsRead();
        }
        else
        {
            System.out.println("failed read file as PNG image");
        }
    }
}
