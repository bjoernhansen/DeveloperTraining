package training.test_examples;

import org.junit.jupiter.api.Test;
import training.test_examples.helper.SomeExampleClass;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.withPrecision;


public class TestingAssertJ
{
    private List<String>
        characters = Arrays.asList("Sauron", "Frodo", "Bilbo");
    
    
    @Test
    void chainedAssertionsTest()
    {
        assertThat("Frodo").isIn(characters)
                           .startsWith("Fro")
                           .endsWith("do")
                           .isEqualToIgnoringCase("frodo");
        
    }
    
    @Test
    void listTest()
    {
        assertThat(characters)
            .isNotEmpty()
            .contains("Frodo")
            .doesNotContainNull()
            .containsSequence("Frodo", "Bilbo");
    }
    
    @Test
    void simpleExamplesTest()
    {
        assertThat("".isEmpty()).isTrue();
    }
    
    @Test
    void recursiveComparisonTest()
    {
        SomeExampleClass someExampleClass1 = new SomeExampleClass(12, "Primzahl", false);
        SomeExampleClass someExampleClass2 = new SomeExampleClass(6, "Beine von Insekten", true);
    
        assertThat(someExampleClass1).usingRecursiveComparison().isNotEqualTo(someExampleClass2);
    }
    
    @Test
    void characterTest()
    {
        char d = 'd';
        assertThat(d)
            .isNotEqualTo('a')
            .inUnicode()
            .isGreaterThanOrEqualTo('b')
            .isLowerCase();
    }
    
    @Test
    void classTest()
    {
        assertThat(Runnable.class).isInterface();
    
        // or if you want to check if one class is assignable from the other:
        assertThat(Exception.class).isAssignableFrom(NoSuchElementException.class);
    }
    
    @Test
    void fileTest()
    {
        File file = new File("logs/log.txt");
        
        assertThat(file)
            .exists()
            .isFile()
            .canRead()
            .canWrite();
    }
    
    @Test
    void mathTest()
    {
        double epsilon = 0.001;
        assertThat(5.0000001).isEqualTo(5, withPrecision(epsilon));
    }
    
    @Test
    void exceptionTest()
    {
        assertThatThrownBy(() -> {
            List<String> list = Arrays.asList("String one", "String two");
            list.get(2);
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("Index 2 out of bounds for length 2");
        
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                List<String> list = Arrays.asList("String one", "String two");
                list.get(2);
            }).withMessageMatching("Index \\d+ out of bounds for length \\d+");
    }
}
