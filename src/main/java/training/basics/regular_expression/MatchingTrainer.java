package training.basics.regular_expression;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MatchingTrainer
{
    public static void main(String[] args)
    {
        tryOutMatching();
        tryOutWithCertainSymbols();
        tryOutFind();
        tryOutSplit();
        tryOutPredicate();
        tryOutGrouping();
        tryOutNegativeLookAhead();
        tryOutPositiveLookAhead();
        tryOutRegularExpressionSupportForStrings();
        tryOutStartAndEnd();
    }
    
    private static void tryOutMatching()
    {
        System.out.println("\nMatch:");
        
        String regex = ".*a*.?c\\n[tb](.{3})U*\\\\";
        String input = "UUUUUUUaaac\nt123UUU\\";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        boolean isMatching1 = matcher.matches();
        boolean isMatching2 = Pattern.matches(regex, input);
        
        System.out.println("Match? " + (isMatching1 && isMatching2));
    }
    
    private static void tryOutWithCertainSymbols()
    {
        System.out.println("\nMatch in symbol test:");
        
        String regex = "[^abc][abc]|u+";
        String input = "uuuuuu";
        
        boolean isMatching = Pattern.compile(regex)
                                    .matcher(input)
                                    .matches();
        
        System.out.println("Match? " + isMatching);
    }
    
    private static void tryOutFind()
    {
        System.out.println("\nFind:");
        
        String findRegex = "a*.?c\n[tb](.{3})$";
        String input = "UUUUUUUaaac\nt123";
        
        Pattern findPattern = Pattern.compile(findRegex);
        Matcher findMatcher = findPattern.matcher(input);
        boolean isMatching3 = findMatcher.find();
        System.out.println("Find? " + isMatching3);
    }
    
    private static void tryOutSplit()
    {
        System.out.println("\nSplit:");
        
        String inputSplit = "45354535_434_34343434_88";
        
        Pattern pattern2 = Pattern.compile("_");
        
        List.of(pattern2.split(inputSplit))
            .forEach(System.out::println);
    }
    
    private static void tryOutPredicate()
    {
        List<String> animal = List.of("Biber", "Löwe", "Amsel", "Schwalbe", "Storch", "Lurch");
    
        {
            System.out.println("\nPredicate");
        
            Predicate<String> animalPredicate1 = Pattern.compile("e")
                                                        .asPredicate();
            animal.stream().filter(animalPredicate1).forEach(System.out::println);
        }
    
        {
            System.out.println("\nMatchPredicate");
            
            Predicate<String> animalPredicate2 = Pattern.compile(".*e.*")
                                                        .asMatchPredicate();
            animal.stream().filter(animalPredicate2).forEach(System.out::println);
        }
    }
    
    private static void tryOutGrouping()
    {
        System.out.println("\nGrouping");
        
        String example = "Hallo    , wie geht es euch? Bert    , nun sag schon was   .";
        
        String pattern = "(\\w)(\\s+)([.,])";
        System.out.println(example.replaceAll(pattern, "$1$3"));
    
        // (?i) optional, macht match case insensitiv
        pattern = "(?i)(<title.*?>)(.+?)";
        String example2 = "<tiTlE data-l10n-id=\"newtab-page-title\">Marder";
        
        String updated = example2.replaceAll(pattern, "$2");
        System.out.println(updated);
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
        String input = "Meine Katze mag des Nachbarn Katze weniger gerne als meine Katze.";
        
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
