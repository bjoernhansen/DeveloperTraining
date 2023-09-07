package training.design_pattern.chain_of_responsibility;

public class Main
{
    public static final String
        FILE_NAME = "Bild.qbw";

    public static void main(String[] args)
    {
        var pngFileReader = new PngFileReader(null);
        var quickBookReader = new QuickBookReader(pngFileReader);
        FileReader fileReader = new ExcelFileReader(quickBookReader);

        fileReader.read(FILE_NAME);
    }
}
