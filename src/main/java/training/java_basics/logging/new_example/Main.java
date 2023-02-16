package training.java_basics.logging.new_example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main
{
    private static final Logger
        log = LogManager.getRootLogger();
    
    
    public static void main(String[] args)
    {
        /** Important note: To make it work, rename log4j2.properties from the other example (or it would be preferably used)
         * and then rename log4j2.xml_invisible to log4j2.xml
         * Both files are located in the source root*/
        
        log.info("start");
        
        A a = new A();
        a.aM1();
        
        B b = new B();
        b.bM1();
        
        C c = new C();
        c.cM1();
        
        log.info("end");
    }
}
