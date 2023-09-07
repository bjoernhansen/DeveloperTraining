package training.basics.enums.interoperating_enums;


public class Main {

    private static final boolean
        IS_SQR = true;

    public static void main(String[] args) {
        SqrType sqrType = IS_SQR ? SqrType.SQR : SqrType.NO_SQR;

        // example for data retrieval

        DateType dateType = DateType.getDateType("key:linkdate");
        System.out.println(dateType);

        int linkDateOffset = sqrType.getOffset(DateType.LINK_DATE);
        String linkDateFeatureKey = DateType.LINK_DATE.getFeatureKey();

        System.out.printf("linkDateOffset: %d; linkDateFeatureKey: %s%n", linkDateOffset, linkDateFeatureKey);
    }
}
