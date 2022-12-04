package training.java_basics.enums.interoperating_enums;


public class Main {

    private static final boolean
        IS_SQR = true;

    public static void main(String[] args) {
        SqrType sqrType = IS_SQR ? SqrType.SQR : SqrType.NO_SQR;

        // example for data retrieval
        int linkDateOffset = sqrType.getOffset(PackagingBriefingDateOffsetType.LINKDATE);
        String linkDateFeatureKey = PackagingBriefingDateOffsetType.LINKDATE.getFeatureKey();

        System.out.printf("linkDateOffset: %d; linkDateFeatureKey: %s%n", linkDateOffset, linkDateFeatureKey);
    }
}
