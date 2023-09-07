package training.design_pattern.chain_of_responsibility;

public class ExcelFileReader extends FileReader
{
    public ExcelFileReader(FileReader next)
    {
        super(next);
    }

    @Override
    void tryToRead(String filename)
    {
        if (filename.endsWith(".xls")) {
            System.out.println("Reading data from an Excel spreadsheet.");
            markAsRead();
        }
        else
        {
            System.out.println("failed read file as Excel spreadsheet");
        }
    }
}
