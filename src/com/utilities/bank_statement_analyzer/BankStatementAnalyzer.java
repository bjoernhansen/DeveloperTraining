package com.utilities.bank_statement_analyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class BankStatementAnalyzer {
    private static final String RESOURCES = "src/com/utilities/bank_statement_analyzer/";
    

    void analyze(final String fileName,
                        final BankStatementParser bankStatementParser,
                        final Exporter exporter) throws IOException {

        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        final SummaryStatistics summaryStatistics = bankStatementProcessor.summarizeTransactions();

        System.out.println(exporter.export(summaryStatistics));

    }
}
