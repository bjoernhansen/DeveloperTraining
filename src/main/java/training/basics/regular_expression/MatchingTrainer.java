package training.basics.regular_expression;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Tipp: https://www.kompf.de/java/regex.html

public class MatchingTrainer
{
    public static void main(String[] args)
    {
        practicalExamples();
        tryOutMatching();
        tryOutMatching2();
        tryOutWithCertainSymbols();
        tryOutFind();
        tryOutSplit();
        tryOutPredicate();
        tryOutGrouping();
        tryOutLookAhead();
        tryOutNegativeLookAhead();
        tryOutPositiveLookAhead();
        tryOutRegularExpressionSupportForStrings();
        tryOutStartAndEnd();
    }

    private static void practicalExamples()
    {
        String regex = "\\$\\((.*?)\\)";
        String input = "Der $(graue Esel) liegt unter der $(grünen Wiese) und genießt die $(gelbe Sonne).";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        System.out.println("Wie oft ist ein bestimmter Substring enthalten?");
        printFindCount(matcher);

        System.out.println("\nTexte innerhalb eines bestimmten Musters herausfiltern");
        printFindings(matcher);

        System.out.println("\nErsetzungen eines bestimmten Musters");
        printReplacedFindings(matcher);
    }

    private static void printFindCount(Matcher matcher)
    {
        matcher.reset();
        int findCount = 0;
        while(matcher.find())
        {
            findCount++;
        }
        System.out.println(findCount);
    }

    private static void printFindings(Matcher matcher)
    {
        matcher.reset();
        while(matcher.find())
        {
            System.out.println(matcher.group(0));
        }
    }

    private static void printReplacedFindings(Matcher matcher)
    {
        matcher.reset();
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuilder, convert(matcher.group(1)));
        }
        matcher.appendTail(stringBuilder);
        System.out.println(stringBuilder);
    }

    private static String convert(String text)
    {
        return "<color>" + text + "</color>";
    }

    private static void tryOutMatching()
    {
        System.out.println("\nMatch:");

        String regex = ".*a*.?c\\n[tb](.{3})U*\\\\"; // Backslashes müssen doppelt geschrieben werden
        String input = "UUUUUUUaaaXc\nt123UUU\\";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        boolean isMatching1 = matcher.matches();
        boolean isMatching2 = Pattern.matches(regex, input); // alternative Schreibweise

        System.out.println("Match? " + (isMatching1 && isMatching2));
    }



    private static void tryOutMatching2()
    {
        System.out.println("\nMatch:");

        String regex = "a+\\na+"; //        \\nist das Zeichen für den Zeilenumbruch (beides wird gefunden)
        String regex2 = "a+\na+"; //        \n ist der Zeilenumbruch
        String regex3 = "a+\\\\na+"; //     \\\\n sind die Zeichen \ und n hintereinander

        String input1 = "aaaaa\naaaaaaa";
        String input2 = "aaaaa\\naaaaaaa";

        System.out.println("Match? " + Pattern.matches(regex, input1));
        System.out.println("Match? " + Pattern.matches(regex2, input1));
        System.out.println("Match? " + Pattern.matches(regex3, input2));
    }

    private static void tryOutWithCertainSymbols()
    {
        System.out.println("\nMatch in symbol test:");

        String regex = "[abc]([^abc]|u+)"; // Klammern können auch gesetzt werden für die Reihenfolge der Auswertung
        String input1 = "auuuuuu";
        String input2 = "ct";

        boolean isMatching1 = Pattern.compile(regex)
                                     .matcher(input1)
                                     .matches();

        boolean isMatching2 = Pattern.compile(regex)
                                     .matcher(input2)
                                     .matches();

        System.out.println("Match? " + isMatching1);
        System.out.println("Match? " + isMatching2);
    }

    private static void tryOutFind()
    {
        System.out.println("\nFind:");

        String findRegex = "a*.?c\n[tb](.{3})(a)$";
        String input = "UUUUUUUaaac\nt123a";

        Pattern pattern = Pattern.compile(findRegex);
        Matcher matcher = pattern.matcher(input);
        System.out.println("Find? " + matcher.find());

        System.out.println("String after Replacement: " + matcher.replaceFirst("replacement"));

        System.out.println(matcher);


        //matcher.group()
    }

    private static void tryOutSplit()
    {
        System.out.println("\nSplit:");

        String inputSplit = "45354535_434_34343434_88";

        Pattern pattern = Pattern.compile("_");
        List.of(pattern.split(inputSplit))
            .forEach(System.out::println);

        List.of(inputSplit.split("-"))  // Alternative direkt auf String
            .forEach(System.out::println);
    }

    private static void tryOutPredicate()
    {
        List<String> animal = List.of("Biber", "Löwe", "Amsel", "Schwalbe", "Storch", "Lurch");

        {
            System.out.println("\nPredicate");

            Predicate<String> animalPredicate1 = Pattern.compile("e")
                                                        .asPredicate();
            animal.stream()
                  .filter(animalPredicate1)
                  .forEach(System.out::println);
        }

        {
            System.out.println("\nMatchPredicate");

            Predicate<String> animalPredicate2 = Pattern.compile(".*e.*")
                                                        .asMatchPredicate();
            animal.stream()
                  .filter(animalPredicate2)
                  .forEach(System.out::println);
        }
    }

    private static void tryOutGrouping()
    {
        System.out.println("\nGrouping");

        String example = "Hallo    , wie geht es euch? Bert    , nun sag schon was   .";

        String pattern1 = "(\\w)(\\s+)([.,])";
        System.out.println(example.replaceAll(pattern1, "$1$3"));

        // (?i) optional, macht match case insensitiv
        String pattern2 = "(?i)(<title.*?>)(.+?).*";
        String example2 = "<tiTlE data-l10n-id=\"newtab-page-title\">Marder";

        String updated = example2.replaceAll(pattern2, "$2");
        System.out.println(updated);
    }


    private static void tryOutLookAhead()
    {
        String input = "abc def";

        // Positive Lookahead: Suche nach "a", gefolgt von "b"
        String regex1 = "a(?=b)";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(input);
        // Ergebnis: Es wird kein Match gefunden, da "a" nicht von "b" gefolgt wird.
        System.out.println(matcher1.find()); // Ausgabe: false

        // Negative Lookahead: Suche nach "a", das nicht von "b" gefolgt wird
        String regex2 = "a(?!b)";
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(input);
        // Ergebnis: Es wird ein Match für das "a" gefunden, da es nicht von "b" gefolgt wird.
        System.out.println(matcher2.find()); // Ausgabe: true

        System.out.println(System.getProperty("wewe"));
    }


    private static void tryOutNegativeLookAhead()
    {
        System.out.println("\nNegativeLookAhead:");

        // a not followed by b
        String regex = ".*a(?!b).*";
        String input = "cbaab";

        boolean isMatching = Pattern.matches(regex, input);

        System.out.println("Match? " + isMatching);
    }

    private static void tryOutPositiveLookAhead()
    {
        System.out.println("\nPositiveLookAhead:");

        // a not followed by b
        String regex = "([abc][^abc]c)\\1\\1";
        String input = "akcakcakc";

        boolean isMatching = Pattern.matches(regex, input);

        System.out.println("Match? " + isMatching);
    }

    static void tryOutRegularExpressionSupportForStrings()
    {
        System.out.println("Replace substring");
        System.out.println("Schinkenwurst".replaceFirst("[aeou]", "i"));
        System.out.println("Schinkenwurst".replaceAll("[aeou]", "i"));
    }

    private static void tryOutStartAndEnd()
    {
        System.out.println("\nTesting start() and end():");

        String regex = "Katze";
        String input = "Meine Katze mag die Katze des Nachbarn weniger gerne als meine eigene Katze.";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        matcher.find();
        System.out.println(input.substring(0, matcher.end()));
        matcher.find();
        System.out.println(input.substring(0, matcher.end()));
        matcher.find();
        System.out.println(input.substring(0, matcher.end()));

        matcher.reset();
        matcher.find();
        System.out.println(input.substring(0, matcher.end()));

        System.out.println(input.substring(matcher.start(), matcher.end()));
    }
}
