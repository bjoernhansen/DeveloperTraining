package training.test_examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import training.test_examples.helper.SimpleMath;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class DynamicTestsWithTestFactoryTest
{
    @TestFactory
    Collection<DynamicTest> dynamicTestsWithCollection() {
        return Arrays.asList(
            DynamicTest.dynamicTest("Add test",
                () -> assertEquals(2, Math.addExact(1, 1))),
            DynamicTest.dynamicTest("Multiply Test",
                () -> assertEquals(4, Math.multiplyExact(2, 2))));
    }
    
    @TestFactory
    @DisplayName("all squares of uneven numbers are odd")
    Stream<DynamicTest> allSquaresOfUnevenNumbersAreOdd()
    {
        return IntStream.range(1, 10)
                        .boxed()
                        .filter(number -> number%2!=0)
                        .map(SimpleMath::square)
                        .map(number -> DynamicTest.dynamicTest("Square = " + number, () -> assertTrue(SimpleMath.isOdd(number))));
    }
}
