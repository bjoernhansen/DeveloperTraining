package com.collections;

import java.util.HashMap;
import java.util.Map;


public class MapTesting {

    public static void main(String[] args) {

        Map<String, Integer> stringIntegerMap = new HashMap<>();

        stringIntegerMap.put("Apfelbaum", 12);

        System.out.println(stringIntegerMap.computeIfAbsent("Apfelbaum", String::length));
        System.out.println(stringIntegerMap.computeIfAbsent("Schlüssel", s -> 999));
    }
}