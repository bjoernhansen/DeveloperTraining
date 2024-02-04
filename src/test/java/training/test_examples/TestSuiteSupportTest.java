package training.test_examples;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TestSuiteSupportTest {
    @Test
    @Tag("bjoern")
    void passingTest1() {
        assertThat(getTrue()).isTrue();
    }

    @Test
    void passingTest2() {
        assertThat(getTrue()).isTrue();
    }

    private boolean getTrue() {
        return true;
    }
}
