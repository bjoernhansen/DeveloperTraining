package training.test_examples;

import org.junit.platform.suite.api.*;
import training.test_examples.test_data.StuffedAnimalTest;

@Suite
@SuiteDisplayName("JUnit Platform Suite Demo")
@SelectClasses({AssumptionTest.class, IgnoredTestsTest.class, TestSuiteSupportTest.class})
@SelectPackages({"training.test_examples.parameterized_tests"}) // also executes all classes from sub-packages.
@ExcludePackages("training.test_examples.parameterized_tests.csv_source")
@ExcludeClassNamePatterns("training.test_examples.test_data.*Test") // Auswahl der Tests anhand eines Musters
@ExcludeTags("bjoern")
@SelectMethod(type = StuffedAnimalTest.class, name = "chainedAssertionsTest")
// es gibt auch die Include-Varianten der Annotation, dann wird ausschließlich die Auswahl verwendet und alles andere ignoriert
class TestSuiteExample {
    /*
    weiterführende Links:
    https://www.baeldung.com/java-junit-test-suite
     */
}