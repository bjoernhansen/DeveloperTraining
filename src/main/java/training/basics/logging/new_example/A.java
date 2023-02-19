package training.basics.logging.new_example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class A
{
    static Logger log = LogManager.getLogger();
    
    public void aM1()
    {
        log.info("start");
        log.debug("debug...");
        log.warn("warn...");
    }
}
