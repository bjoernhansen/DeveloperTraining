package com.java_basics.enums.interoperating_enums;


public class Main {

    private static final boolean IS_SQR = true;

    public static void main(String[] args) {
        boolean isSqr = IS_SQR;
        SqrType sqrType = isSqr ? SqrType.SQR : SqrType.NO_SQR;

        // example for data retrival
        int linkdateOffset = sqrType.getOffset(PackagingBriefingDateOffsetType.LINKDATE);
        String linkdateFeatureKey = PackagingBriefingDateOffsetType.LINKDATE.getFeatureKey();

        System.out.println(String.format("linkdateOffset: %d; linkdateFeatureKey: %s", linkdateOffset, linkdateFeatureKey));
    }
}
