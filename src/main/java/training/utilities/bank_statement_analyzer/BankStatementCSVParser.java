package training.utilities.bank_statement_analyzer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.util.stream.Collectors.toList;

class BankStatementCSVParser implements BankStatementParser {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public BankTransaction parseFrom(final String line) {
        final String[] columns = line.split(",");

        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);

        return new BankTransaction(date, amount, columns[2]);
    }

    @Override
    public List<BankTransaction> parseLinesFrom(final List<String> lines) {
        return lines.stream().map(this::parseFrom).collect(toList());
    }
}
