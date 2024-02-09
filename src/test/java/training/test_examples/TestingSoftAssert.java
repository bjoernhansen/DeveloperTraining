package training.test_examples;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;


class TestingSoftAssert
{
    private record Person(String vorname, String nachname, int alter) {}
    
    private static final int AGE_OF_MAJORITY = 18;
    
    private final Person klausMeyer = new Person("Klaus", "Meyer", 18);
    
    @Test
    void testSoftAssertions()
    {
        // SoftAssertions erstellen
        SoftAssertions softly = new SoftAssertions();
        
        // Prüfen des Namens
        softly.assertThat(klausMeyer)
              .as("Vorname")
              .returns("Klaus", Person::vorname)
              .as("Nachname")
              .returns("Meyer", Person::nachname);
        
        // Volljährigkeit prüfen
        softly.assertThat(klausMeyer.alter)
              .as("Volljährigkeit")
              .isGreaterThanOrEqualTo(AGE_OF_MAJORITY);
        
        // Überprüfen, ob 2 kleiner als 3 ist
        softly.assertThat(2)
              .as("2 ist kleiner als 3")
              .isLessThan(3);
        
        // Alle Prüfungen ausführen und Fehler sammeln
        softly.assertAll();
    }
}
