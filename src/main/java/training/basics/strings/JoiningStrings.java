package training.basics.strings;

import java.util.StringJoiner;

public class JoiningStrings {

    public static void main(String[] args) {
        StringJoiner joiner = new StringJoiner(",");
        joiner.add("01")
              .add("02")
              .add("03");
        String joinedString = joiner.toString(); // "01,02,03"
        String joinedString2 = String.join(" - ", "04", "05", "06"); // "04 - 05 - 06"


        StringBuilder s;
    }
}