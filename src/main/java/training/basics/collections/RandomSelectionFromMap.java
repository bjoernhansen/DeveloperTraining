package training.basics.collections;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * Example taken from <a href="https://www.baeldung.com/java-hashmap-random-key-value-entry">baeldung</a>
 */
public class RandomSelectionFromMap
{
    Random random = new Random();
    
    
    
    
    <K, V> K randomKeyUsingStream(Map<K, V> map) {
  
        return map.keySet()
                  .stream()
                  .skip(random.nextInt(map.size()))
                  .findFirst()
                  .orElseThrow();
    }
    
    <K, V> V randomValueUsingStream(Map<K, V> map) {
        return map.values()
                  .stream()
                  .skip(random.nextInt(map.size()))
                  .findFirst()
                  .orElseThrow();
    }
    
    <K, V> Map.Entry<K, V> randomEntryUsingStream(Map<K, V> map) {
        return map.entrySet()
                  .stream()
                  .skip(random.nextInt(map.size()))
                  .findFirst()
                  .orElseThrow();
    }
    
    public static Map<String, String> createFruitMap() {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("Key-A", "Apfel");
        dataMap.put("Key-B", "Birne");
        dataMap.put("Key-C", "Kirsche");
        dataMap.put("Key-D", "Pflaume");
        dataMap.put("Key-E", "Zitrone");
        dataMap.put("Key-F", "Melone");
        dataMap.put("Key-G", "Mandarine");
        dataMap.put("Key-H", "Weintraube");
        return dataMap;
    }
    
    public static void main(String[] args)
    {
        Map<String, String> fruitMap = createFruitMap();
        RandomSelectionFromMap randomSelectionFromMap = new RandomSelectionFromMap();
        String randomKey = randomSelectionFromMap.randomKeyUsingStream(fruitMap);
        String randomValue = randomSelectionFromMap.randomValueUsingStream(fruitMap);
        Map.Entry<String, String> stringStringEntry = randomSelectionFromMap.randomEntryUsingStream(fruitMap);
        
        System.out.println(randomKey + " " + randomValue + " " + stringStringEntry.toString());
    }
}
