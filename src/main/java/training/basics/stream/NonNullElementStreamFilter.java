package training.basics.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class NonNullElementStreamFilter
{
    public static void main(String[] args)
    {
        List<Integer> myList = Arrays.asList(null, null, 2, null, 1);
        System.out.println(myList.stream()
                                 .filter(Objects::nonNull)
                                 .map(i -> i * i)
                                 .filter(i -> i > 0)
                                 .findFirst()
                                 .orElse(0));
    }
}
