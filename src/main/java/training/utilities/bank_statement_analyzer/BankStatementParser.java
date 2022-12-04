package training.utilities.bank_statement_analyzer;

import java.util.List;

interface BankStatementParser {
    BankTransaction parseFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}
