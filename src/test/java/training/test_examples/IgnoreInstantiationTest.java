package training.test_examples;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class IgnoreInstantiationTest
{
    @Test
    void testNoNullPointerExcetionWhenInstantiated () {
        Consumer<Object> ignoreInstantiation = obj -> {};
        assertThatThrownBy(
            () -> ignoreInstantiation.accept(MyClass.makeInstance())
        ).isNotInstanceOf(NullPointerException.class);
    }
    
    private static class MyClass
    {
        private static MyClass makeInstance()
        {
            throw new UnsupportedOperationException();
        }
    }
}
