package training.basics.java17;

public class TestingRecords
{
    record TestRecord(int number, String text){};
    
    
    public static void main(String[] args)
    {
        TestRecord testRecord = new TestRecord(12, "my text");
        System.out.println(testRecord);
    }
}
