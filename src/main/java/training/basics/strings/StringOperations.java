package training.basics.strings;

public class StringOperations
{
    public static final String
        EXAMPLE_STRING = "abgba";
    
    
    public static void main(String[] args)
    {
        System.out.println(reverse(EXAMPLE_STRING));
        System.out.println(EXAMPLE_STRING + " is " + (isPalindrom1(EXAMPLE_STRING) ? "" : "NOT ") + "a palindrome!");
    }
    
    public static String reverse(String input)
    {
        char[] charArray = input.toCharArray();
        int leftIndex = 0;
        int rightIndex = charArray.length - 1;
    
        while (rightIndex > leftIndex) {
            char temp = charArray[leftIndex];
            charArray[leftIndex] = charArray[rightIndex];
            charArray[rightIndex] = temp;
            rightIndex--;
            leftIndex++;
        }
        return new String(charArray);
    }
    
    public static boolean isPalindrom1(String string)
    {
        int length = string.length();
        String start = string.substring(0, length / 2);
        String end = string.substring(length - length / 2, length);
        return start.equals(reverse(end));
    }
    
    public static boolean isPalindrom2(String string)
    {
        int length = string.length();
        for (int i = 0; i < length / 2; i++) {
            if (string.charAt(i) != string.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
