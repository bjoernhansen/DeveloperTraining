package training.basics.java17.pattern_matching;

class PatternMatchingExample
{
    public static void main(String[] args) {
        Object obj = getObject();
        
        if (obj instanceof String str) {
            System.out.println("The object is a String: " + str);
            System.out.println("String length: " + str.length());
        } else {
            System.out.println("The object is not a String.");
        }
    }
    
    private static Object getObject()
    {
        return "Hello, World!";
    }
}
