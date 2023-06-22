package training.basics.java17;

class MultilineText
{
    private static final String SQL = """
        SELECT books.id, title, publId, name
        FROM books
        JOIN publishers ON publId = publishers.id
        WHERE books.id >= 167""";
    
    private static final String EXAMPLE_TEXT = """
       abc
         efg
    """;
    // entspricht s = "   abc\n" +
    //                "     efg\n";
    
    
    public static void main(String[] args)
    {
        System.out.println(SQL);
        System.out.println(EXAMPLE_TEXT);
    }
}
