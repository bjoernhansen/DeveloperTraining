package training.basics.java17;

class EnhancedSwitch
{
    private enum Teletubby
    {TINKYWINKY, DIPSY, LALA, PO}
    
    
    public static void main(String[] args)
    {
        // Example 1
        String month = getMonth();
        int days =
            switch(month)
            {
                case "Januar", "März", "Mai", "Juli", "August",
                    "Oktober", "Dezember" -> 31;
                case "April", "Juni", "September",
                    "November" -> 30;
                case "Februar" -> 28; // oder 29, wenn Schaltjahr
                default -> 0;
            };
        System.out.printf("Tage im Monat %s: %d", month, days);
        
        // Example 2
        Teletubby teletubby = getTeletubby();
        
        switch(teletubby)
        {
            case TINKYWINKY, DIPSY ->
            {
                System.out.println("Geschlecht: ");
                System.out.println("männlich");
            }
            case LALA ->
            {
                System.out.println("Geschlecht: ");
                System.out.println("weiblich");
            }
            default -> System.out.println("Po ist weiblich");
        }
    }
    
    private static String getMonth()
    {
        return "März";
    }
    
    private static Teletubby getTeletubby()
    {
        return Teletubby.TINKYWINKY;
    }
}
