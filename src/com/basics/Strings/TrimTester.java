package com.basics.Strings;

public class TrimTester {

    public static void main(String[] args) {

        String s = "öbcde";

        //System.out.println(s.replaceAll(" ", "")); ab 128
        // &#x%02x; --> bis 255 , aber 256 --> &#x%04x;

        System.out.println(String.format("&#x%04x;", (int)(s.charAt(0))));



    }


}
