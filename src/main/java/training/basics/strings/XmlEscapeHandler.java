package training.basics.strings;


import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class XmlEscapeHandler {

    public static String HEX_FORMAT_STRING_02 = "&#x%02X;";
    public static String HEX_FORMAT_STRING_04 = "&#x%04X;";


    static Set<Character> vorbittenCharacters = new HashSet<>((Arrays.asList('<', '>', '&', '\"', '\'')));
    //private final Set<Character> additionalCharactersToBeEscaped = Set.of('<', '>', '&', '\"', '\'');

    public static void main(String[] args) {

        String test = "Äber öch nüch!!&&ß >< Ok編碼方法 Ok '' \"";

        // final NioEscapeHandler nioEscapeHandler = new NioEscapeHandler();

        System.out.println(escape(test));
        System.out.println(escapeNew(test));

        escapeNew(test);
        escapeNew(test);
    }

    public static String escape(String buf) {
        StringWriter buffer = new StringWriter();

        for (int i = 0; i <buf.length(); i++) {
            String outString;
            if (buf.charAt(i) < 128 && !vorbittenCharacters.contains(buf.charAt(i))) {
                outString = String.valueOf(buf.charAt(i) );
            } else if (buf.charAt(i) < 256) {
                outString = String.format(HEX_FORMAT_STRING_02, (int) (buf.charAt(i)));
            } else {
                outString = String.format(HEX_FORMAT_STRING_04, (int) (buf.charAt(i)));
            }
            buffer.write(outString);
        }
        return buffer.toString();
    }

    public static String escapeNew(String buf) {
        StringWriter buffer = new StringWriter();

        for (int i = 0; i <buf.length(); i++) {
            String outString;
            if (buf.charAt(i) < 128 && !vorbittenCharacters.contains(buf.charAt(i))) {
                outString = String.valueOf(buf.charAt(i) );
            } else if (buf.charAt(i) < 256) {
                outString = "&#x" + Integer.toHexString(buf.charAt(i)).toUpperCase()  + ";";
            } else {
                outString = "&#x" + Integer.toHexString(buf.charAt(i)).toUpperCase()  + ";";
            }
            buffer.write(outString);
        }
        return buffer.toString();
    }
}