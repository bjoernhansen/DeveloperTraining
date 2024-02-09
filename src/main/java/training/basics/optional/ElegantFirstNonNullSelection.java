package training.basics.optional;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;


public class ElegantFirstNonNullSelection
{
    private record Person(String name) {}
    
    public static void main(String[] args)
    {
        Person person = new Person("Klaus Meyer");
        String choiceForKlaus = getChoiceFor(person);
        System.out.println(choiceForKlaus);
    }
    
    public static String getChoiceFor(Person person)
    {
        return findNonNullIfAny(
            () -> bestChoice(person),
            () -> secondBestChoice(person),
            () -> worstChoice(person)
        ).orElse(noChoiceFor(person));
    }
    
    @SafeVarargs
    private static Optional<String> findNonNullIfAny(Supplier<Optional<String>>... choices)
    {
        return Stream.of(choices)
                     .map(Supplier::get)
                     .flatMap(Optional::stream)
                     .findFirst();
    }
    
    private static Optional<String> bestChoice(Person person)
    {
        return excepted() ? Optional.of("Best choice for " + person.name) : Optional.empty();
    }
    
    private static Optional<String> secondBestChoice(Person person)
    {
        return excepted() ? Optional.of("Second best choice for " + person.name) : Optional.empty();
    }
    
    private static Optional<String> worstChoice(Person person)
    {
        return excepted() ? Optional.of("Worst choice for " + person.name) : Optional.empty();
    }
    
    private static boolean excepted()
    {
        return Math.random() > 0.6;
    }
    
    private static String noChoiceFor(Person person)
    {
        return "No choice for " + person.name;
    }
}
