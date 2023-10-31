package training.basics.logging.example_2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class B
{
    static Logger log = LogManager.getLogger();
    
    public void bM1()
    {
        log.info("start");
        log.debug("debug...");
        log.warn("warn...");
    }
}
