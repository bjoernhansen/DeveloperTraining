package training.design_pattern.proxy;

public class RealEbook implements Ebook
{
    private final String fileName;


    public RealEbook(String fileName)
    {
        this.fileName = fileName;
        load();
    }

    private void load()
    {
        System.out.println("Loading Ebook " + fileName);
    }


    @Override
    public void show()
    {
        System.out.println("Showing Ebook " + fileName);
    }

    @Override
    public String getName()
    {
        return fileName;
    }
}
