package training.basics.enums.interoperating_enums;

import java.util.EnumMap;
import java.util.Map;


public enum SqrType
{
    SQR(2, 9, 15, 17),
    NO_SQR(2, 4, 10, 12);


    private final Map<DateType, Integer>
        map = new EnumMap<>(DateType.class);

    SqrType(int layoutDate, int finalLayoutDate, int finalArtWorkDate, int linkDate)
    {
        map.put(DateType.LAYOUT_DATE, layoutDate);
        map.put(DateType.FINAL_LAYOUT_DATE, finalLayoutDate);
        map.put(DateType.FINAL_ARTWORK_DATE, finalArtWorkDate);
        map.put(DateType.LINK_DATE, linkDate);
    }

    public Integer getOffset(DateType offsetType)
    {
        return map.get(offsetType);
    }
}
