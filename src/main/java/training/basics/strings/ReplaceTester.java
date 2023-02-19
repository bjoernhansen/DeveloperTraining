package training.basics.strings;

public class ReplaceTester {

    public static void main(String[] args) {
        String test = "Mein String: äöüß";
        String test2 = test.replace("äöüß", "aous");
        System.out.println(test2);
    }
}
