package training.java_basics.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public enum ExampleType {

    EXAMPLE_ONE(1),
    EXAMPLE_TWO(2),
    EXAMPLE_THREE(3);

    private final static List<ExampleType>        values       = List.of(values());
    private static final Map<String, ExampleType> exampleTypes = new HashMap<>();

    static {
        Arrays.stream(values())
              .forEach(exampleType -> exampleTypes.put(exampleType.name, exampleType));
    }

    final int    number;
    final String name;

    ExampleType(int number) {
        this.number = number;
        this.name = Integer.toString(number);
    }

    public static List<ExampleType> getValues() {
        return values;
    }

    public static ExampleType getExportMode(String notation) {
        return exampleTypes.get(notation);
    }

    public int getNumber() {
        return number;
    }
}