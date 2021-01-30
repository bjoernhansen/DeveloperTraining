package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ListTester {


    public static void main(String[] args) {







        List<String> newList = (ArrayList<String>)getObject();
        System.out.println((newList instanceof List) + " " + newList.getClass().getName());

        newList.forEach(System.out::println);


    }



    private static Object getObject(){
        return Arrays.asList("123", "Klaus", "Gogo");
    }

}
