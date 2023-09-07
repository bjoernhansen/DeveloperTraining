package training.basics.enums.interoperating_enums;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public enum DateType
{
    LAYOUT_DATE("key:layoutdate"),
    FINAL_LAYOUT_DATE("key:finallayoutdate"),
    FINAL_ARTWORK_DATE("key:finalartworkdate"),
    LINK_DATE("key:linkdate");


    private final String
        featureKey;


    private static final Map<String, DateType>
        map = Arrays.stream(DateType.values()).collect(Collectors.toUnmodifiableMap(DateType::getFeatureKey, Function.identity()));

    DateType(String featureKey) {
        this.featureKey = featureKey;
    }

    public String getFeatureKey() {
        return featureKey;
    }

    public static DateType getDateType(String featureKey)
    {
        return map.get(featureKey);
    }
}
