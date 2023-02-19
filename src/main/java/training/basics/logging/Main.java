package training.basics.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main
{
    private static final Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args)
    {
        log.info("Programm start");
        
        A a = new A();
        a.m1();
        a.m2(3);
        a.m3(31);
        a.m4(null);
        // a.m5();
  
        log.info("Programm end");
    }
}
