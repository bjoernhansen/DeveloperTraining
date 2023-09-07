package training.utilities.html;

import com.google.common.html.HtmlEscapers;
import org.apache.commons.text.StringEscapeUtils;

public class CharacterEscaping
{
    public static final String TEXT = "<ok>Björn\n";


    public static void main(String[] args)
    {
        System.out.println(TEXT);

        String escapedTextWithApache = StringEscapeUtils.escapeHtml4(TEXT);
        System.out.println(escapedTextWithApache);

        String escapedTextWithGuava = HtmlEscapers.htmlEscaper().escape(TEXT);
        System.out.println(escapedTextWithGuava);
    }
}
