package com.java_basics.generics;

import java.util.HashMap;
import java.util.Map;

public class Favorites {
    private final Map<Class<?>, Object>
        favorites = new HashMap<>();
    
    public <T> void setFavorite(Class<T> classObject, T thing) {
        favorites.put(classObject, thing);
    }
    
    public <T> T getFavorite(Class<T> classObject) {
        return classObject.cast(favorites.get(classObject));
    }
    
    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.setFavorite(String.class, "Java");
        f.setFavorite(Integer.class, 0xcafebabe);
        String s = f.getFavorite(String.class);
        int i = f.getFavorite(Integer.class);
    }
}