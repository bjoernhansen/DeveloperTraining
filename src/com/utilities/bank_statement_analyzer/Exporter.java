package com.utilities.bank_statement_analyzer;

public interface Exporter {
    String export(SummaryStatistics summaryStatistics);
}
