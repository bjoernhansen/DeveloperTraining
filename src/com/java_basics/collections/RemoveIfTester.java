package com.java_basics.collections;

import java.util.HashMap;
import java.util.Map;

public class RemoveIfTester {

    public static void main(String[] args) {
        Map<String, Long> myLongs = new HashMap<>();
        
        myLongs.put("Lieblingszahl", 123L);
        myLongs.put("Some number", 333L);
        myLongs.put(null, 22L);
        
        myLongs.entrySet().removeIf(e -> e.getValue()%2==0);

        System.out.println(myLongs);
    }
}