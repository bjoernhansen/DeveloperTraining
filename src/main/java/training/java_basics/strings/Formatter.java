package training.java_basics.strings;

import java.util.List;

public class Formatter
{
    private static final String
        FORMAT_STRING_1 = "_%03d",
        FORMAT_STRING_2 = "%3d",
        FORMAT_STRING = FORMAT_STRING_2;
    
    private static final List<Integer>
        numbers = List.of(0, 7, 11, 121, 1031);
    
    public static void main(String[] args) {
        numbers.forEach(Formatter::printFormattedString);
    }
    
    private static void printFormattedString(Integer number)
    {
        String formattedNumber = String.format(FORMAT_STRING, number);
        System.out.println(formattedNumber);
    }
}