package training.basics.javadocs;


/**
 * @author Bjoern Hansen
 *
 */
public class JavaDocExample
{
    /** eine wichtige Konstante **/
    public static final int CONSTANT = 0;
    
    /**
     * @param args werden ben&ouml;tigt
     * @exception RuntimeException tritt auf
     */
    public static void main(String[] args) throws RuntimeException
    {
        throw new RuntimeException();
    }

    /** Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #main}.
     */
    void method()
    {
        
    }

    /**
     * Creates a {@code String} instance which is a concatenation of the input parameters
     * @param text1 first text to be concatenated with {@code text2}
     * @param text2 suffix of the returned String instance
     * @return a concatenation of text1 and text2
     */
    String concat(String text1, String text2)
    {
        return text1 + text2;
    }

}
