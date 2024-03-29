package training.basics.enums.interoperating_enums;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public enum PackagingBriefingDateOffsetType {

    LAYOUTDATE("tchibo:layoutdate"),
    FINALLAYOUTDATE("tchibo:finallayoutdate"),
    FINALARTWORKDATE("tchibo:finalartworkdate"),
    LINKDATE("tchibo:linkdate");

    private final String featureKey;


    private static final Map<String, PackagingBriefingDateOffsetType> map = Arrays.stream(PackagingBriefingDateOffsetType.values())
                                                                                            .collect(Collectors.toUnmodifiableMap(PackagingBriefingDateOffsetType::getFeatureKey,
                                                                                                                                  Function.identity()));

    PackagingBriefingDateOffsetType(String featureKey) {
        this.featureKey = featureKey;
    }

    public String getFeatureKey() {
        return featureKey;
    }
}
