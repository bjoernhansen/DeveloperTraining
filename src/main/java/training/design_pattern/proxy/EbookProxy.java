package training.design_pattern.proxy;


public class EbookProxy implements Ebook
{
    private RealEbook
        realEbook;

    private final String
        name;


    public EbookProxy(String name)
    {
        this.name = name;
    }

    @Override
    public void show()
    {
        if(realEbook == null)
        {
            realEbook = new RealEbook(name);
        }
        realEbook.show();
    }

    @Override
    public String getName()
    {
        return name;
    }
}
