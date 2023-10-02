package training.design_pattern.proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main
{
    public static void main(String[] args)
    {
        Map<String, Ebook> ebooks = new HashMap<>();
        List<String> ebookNames = List.of("a", "b", "c");

        ebookNames.forEach(name -> ebooks.put(name, new EbookProxy(name)));

        ebooks.get("a")
              .show();
    }
}
