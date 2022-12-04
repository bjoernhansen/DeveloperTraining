package training.design_pattern.extension_interface;

class SimpleDocument implements Document, Translatable, Printable
{
    @Override
    public Document getExtension(InterfaceId id)
    {
        switch (id)
        {
            case PRINT:
            case TRANSLATE:
                return this;
        }
        throw new IllegalArgumentException("Could not handle id: " + id);
    }
    
    @Override
    public void print()
    {
        System.out.println("Print document!");
    }
    
    @Override
    public Translatable translate(Language language)
    {
        System.out.println("Translate document to " + language.name());
        return this;
    }
}
