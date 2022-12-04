package training.utilities.bank_statement_analyzer;

@FunctionalInterface
interface BankTransactionSummarizer {
    double summarize(double accumulator, BankTransaction bankTransaction);
}

