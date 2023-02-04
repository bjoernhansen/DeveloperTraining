package training.test_examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


@DisplayName("A point")
class NestedAndWithDisplayedNameTest
{
    @Nested
    @DisplayName("when instantiated")
    class InstantiationTest
    {
        @Test
        @DisplayName("is fine.")
        void of()
        {
        }
    }
}