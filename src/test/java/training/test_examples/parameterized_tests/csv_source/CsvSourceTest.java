package training.test_examples.parameterized_tests.csv_source;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvSourceTest
{
    @ParameterizedTest
    @CsvSource({"Isaac,,Newton,Isaac Newton", "Charles,Robert,Darwin,Charles Robert Darwin"})
    void fullName_ShouldGenerateTheExpectedFullName(ArgumentsAccessor argumentsAccessor) {
        String firstName = argumentsAccessor.getString(0);
        String middleName = (String) argumentsAccessor.get(1);
        String lastName = argumentsAccessor.get(2, String.class);
        String expectedFullName = argumentsAccessor.getString(3);
        
        Person person = new Person(firstName, middleName, lastName);
        assertEquals(expectedFullName, person.fullName());
    }
    
    @ParameterizedTest
    @CsvSource({"Isaac,,Newton,Isaac Newton", "Charles,Robert,Darwin,Charles Robert Darwin"})
    void fullName_ShouldGenerateTheExpectedFullName2(String firstName, String middleName, String lastName, String fullName) {
        Person person = new Person(firstName, middleName, lastName);
        assertEquals(fullName, person.fullName());
    }
    
    @ParameterizedTest
    @CsvSource({"Isaac,Newton,2022-09-11", "Charles Robert,Darwin,2022-07-08"})
    void shouldReadInDateCorrectly(String firstName, String lastName, LocalDate birthdate) {
        System.out.printf("%s %s %s\n", firstName, lastName, birthdate);
        assertThat(birthdate).isBefore(LocalDate.now());
    }
    
    // more readable by using own implementation of an ArgumentAggregator
    @ParameterizedTest
    @CsvSource({"Isaac Newton,Isaac,,Newton", "Charles Robert Darwin,Charles,Robert,Darwin"})
    void fullName_ShouldGenerateTheExpectedFullName(String expectedFullName,
                                                    @AggregateWith(PersonAggregator.class) Person person)
    {
        assertEquals(expectedFullName, person.fullName());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/scientists.csv")
    void csvFileSourceTest(String expectedFullName, @AggregateWith(PersonAggregator.class) Person person)
    {
        assertEquals(expectedFullName, person.fullName());
    }
    
    
    @ParameterizedTest
    @CsvSource({"15, F", "16, 10", "233, E9"})
    void shouldConvertHexadecimalNumbersCorrectly(int decimal,
                                                  @ConvertWith(HexConverter.class) Integer hex)
    {
        assertEquals(decimal, hex);
    }
    
    @ParameterizedTest
    @CsvSource({"15, F", "16, 10", "233, E9"})
    void shouldConvertHexadecimalNumbersWithAnnotationCorrectly(int decimal, @HexValue Integer hex)
    {
        assertEquals(decimal, hex);
    }
}
