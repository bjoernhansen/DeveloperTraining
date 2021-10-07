package com.work.interoperating_enums;

import static com.work.interoperating_enums.PackagingBriefingDateOffsetType.LINKDATE;


public class Main {

    private static final boolean IS_SQR = true;

    public static void main(String[] args) {
        boolean isSqr = IS_SQR;
        SqrType sqrType = isSqr ? SqrType.SQR : SqrType.NO_SQR;

        // example for data retrival
        int linkdateOffset = sqrType.getOffset(LINKDATE);
        String linkdateFeatureKey = LINKDATE.getFeatureKey();

        System.out.println(String.format("linkdateOffset: %d; linkdateFeatureKey: %s", linkdateOffset, linkdateFeatureKey));
    }
}
