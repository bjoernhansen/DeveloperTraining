package training.utilities.bank_statement_analyzer;

class TextExporter implements Exporter
{
    @Override
    public String export(final SummaryStatistics summaryStatistics)
    {
        return "Bank Transaction Report"
                + "\nThe sum is " + summaryStatistics.getSum()
                + "\nThe average is: " + summaryStatistics.getAverage()
                + "\nThe max is: " + summaryStatistics.getMax()
                + "\nThe min is: " + summaryStatistics.getMin() + "\n";
    }
}
