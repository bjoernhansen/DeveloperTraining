package com.java_basics.enums.interoperating_enums;

import java.util.EnumMap;
import java.util.Map;


public enum SqrType {

    SQR(2, 9, 15, 17),
    NO_SQR(2, 4, 10, 12);

    private Map<PackagingBriefingDateOffsetType, Integer> map = new EnumMap(PackagingBriefingDateOffsetType.class);

    SqrType(int layoutdate, int finallayoutdate, int finalartworkdate, int linkdate){
        map.put(PackagingBriefingDateOffsetType.LAYOUTDATE, layoutdate);
        map.put(PackagingBriefingDateOffsetType.FINALLAYOUTDATE, finallayoutdate);
        map.put(PackagingBriefingDateOffsetType.FINALARTWORKDATE, finalartworkdate);
        map.put(PackagingBriefingDateOffsetType.LINKDATE, linkdate);
    }

    public Integer getOffset(PackagingBriefingDateOffsetType offsetType){
        return map.get(offsetType);
    }
}
