package training.design_pattern.extension_interface;

class Main
{
    public static void main(String[] args)
    {
        Document document = new SimpleDocument();
        Translatable translatable = (Translatable) document.getExtension(InterfaceId.TRANSLATE);
        translatable.translate(Language.GERMAN);
        
        Printable printable = (Printable) document.getExtension(InterfaceId.PRINT);
        printable.print();
    }
}
