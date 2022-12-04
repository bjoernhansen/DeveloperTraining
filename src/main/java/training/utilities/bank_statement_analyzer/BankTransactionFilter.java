package training.utilities.bank_statement_analyzer;

@FunctionalInterface
interface BankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}