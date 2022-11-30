package training.java_basics.enums.interoperating_enums;

import java.util.EnumMap;
import java.util.Map;


public enum SqrType {

    SQR(2, 9, 15, 17),
    NO_SQR(2, 4, 10, 12);

    private final Map<PackagingBriefingDateOffsetType, Integer> map = new EnumMap<>(PackagingBriefingDateOffsetType.class);

    SqrType(int layoutDate, int finalLayoutDate, int finalArtWorkDate, int linkDate){
        map.put(PackagingBriefingDateOffsetType.LAYOUTDATE, layoutDate);
        map.put(PackagingBriefingDateOffsetType.FINALLAYOUTDATE, finalLayoutDate);
        map.put(PackagingBriefingDateOffsetType.FINALARTWORKDATE, finalArtWorkDate);
        map.put(PackagingBriefingDateOffsetType.LINKDATE, linkDate);
    }

    public Integer getOffset(PackagingBriefingDateOffsetType offsetType){
        return map.get(offsetType);
    }
}
