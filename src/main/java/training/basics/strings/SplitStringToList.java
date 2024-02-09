package training.basics.strings;

import java.util.Arrays;


public class SplitStringToList
{
    private static final String CSV_LINE = ";;Elefant;Maus;;;Katze;Hund;;;";
    
    public static void main(String[] args)
    {
        System.out.println(Arrays.asList(CSV_LINE.split(";", -1)));
        System.out.println(Arrays.asList(CSV_LINE.split(";"))); // limit by default is 0
    }
}
