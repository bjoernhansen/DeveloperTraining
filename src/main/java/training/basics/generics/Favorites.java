package training.basics.generics;

import java.util.HashMap;
import java.util.Map;

public class Favorites {
    private final Map<Class<?>, Object>
        favorites = new HashMap<>();
    
    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(type, type.cast(instance));
    }
    
    public <T> T getFavorite(Class<T> classObject) {
        return classObject.cast(favorites.get(classObject));
    }
    
    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.putFavorite(String.class, "1");
        f.putFavorite(Integer.class, 0xcafebabe);
        String s = f.getFavorite(String.class);
        int i = f.getFavorite(Integer.class);
    }
}