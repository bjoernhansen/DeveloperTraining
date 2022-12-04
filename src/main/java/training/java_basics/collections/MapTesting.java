package training.java_basics.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MapTesting {

    public static void main(String[] args) {



        Map<String, Integer> stringIntegerMap = new HashMap<>();

        stringIntegerMap.put("Apfelbaum", 12);

        System.out.println(stringIntegerMap.computeIfAbsent("Apfelbaum", String::length));
        System.out.println(stringIntegerMap.computeIfAbsent("Schlüssel", s -> 999));

        String ASSET_TYPE_PHOTO = "";


        new HashMap<>() {{
            put("censhare:asset.type", ASSET_TYPE_PHOTO);
            put("censhare:asset.wf_id", 300);
            put("censhare:asset.wf_step", 40);
            put("tchibo:symboltype  ", null);

        }};

        Stream.of(new Object[][] {
                { "data1", ASSET_TYPE_PHOTO },
                { "data2", 300 },
                { "data3", 40 },
                { "data4", "darf nicht null sein" },
                }).collect(Collectors.toMap(data -> (String) data[0], data -> data[1]));
        }
}
