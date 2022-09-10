package com.java_basics.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * log.info()
 * log.warn()
 * log.error()
 * log.debug()
 * log.fatal()
 */


public class A
{
    private static Logger log = LogManager.getLogger(A.class);

    public void m1()
    {
        log.info("m1 startet");
    }
    
    public void m2(int n)
    {
        log.debug("Parameter: " + n);
    }
    
    public void m3(int temperatur)
    {
        if(temperatur > 30)
        {
            log.warn("Temperatur zu hoch: " + temperatur);            
        }    
    }
    
    public void m4(String s)
    {
        try
        {
            System.out.println(s.length());
        }
        catch (NullPointerException e)
        {
            log.error("Fehler: " + e.fillInStackTrace());
        }
    }
    
    public void m5()
    {
        try 
        {
            m5();
            m5();
        }
        catch(Error e)
        {
            log.fatal("böser Fehler: " + e.fillInStackTrace());
        }
    }
}
