package training.utilities;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class JavaScriptEngine
{
    public static void main(String[] args)
    {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn"); //JavaScript
        try
        {
            Object obj = engine.eval("2*9/3");  // JavaScript-Scripte ausführen
            
            String s = String.valueOf(obj);
            System.out.println(obj + " " + s);
        }
        catch(ScriptException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
