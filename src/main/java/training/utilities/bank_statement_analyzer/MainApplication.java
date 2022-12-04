package training.utilities.bank_statement_analyzer;


class MainApplication
{
    private static final String
        FILE_NAME = "src/main/resources/csv/bank-data-simple.csv";
    
    public static void main(final String[] args) throws Exception
    {
        final BankStatementAnalyzer bankStatementAnalyzer
            = new BankStatementAnalyzer();
        
        final BankStatementParser bankStatementParser
            = new BankStatementCSVParser();
        
        final Exporter exporter = new TextExporter();
        
        bankStatementAnalyzer.analyze(FILE_NAME, bankStatementParser, exporter);
    }
}
