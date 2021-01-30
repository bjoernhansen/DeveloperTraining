package com.testing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class ShuffleTester {


    static List numbersAsText = Arrays.asList("null", "eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun");


    static String number = "01621335975";

    static Random randon = new Random();


    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < number.length(); i++){

            String character = "" + number.charAt(i);
            if(randon.nextInt()%5==0){
                stringBuilder.append(numbersAsText.get(Integer.parseInt(character)));
            }
            else
            {
                stringBuilder.append(character);
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
