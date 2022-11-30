package training.java_basics.reflection;

import java.awt.Rectangle;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

class ReflectionTest
{
    public static void main(String[] args)
    {
        ReflectionTest.printClassHierarchy(UnsupportedOperationException.class);
        
        ReflectionTest.printMethods(Person.class);
        ReflectionTest.printParameter(Person.class);
        ReflectionTest.printGetter(Person.class);
        ReflectionTest.printSetter(Person.class);
        
        //Person p1 = new Person();
        //printMethods(p1.getClass()); // oder Person.class, beides Referenz auf Klassenobjekt
        //System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        
        Rectangle rec = (Rectangle) create("java.awt.Rectangle");
        System.out.println(rec.getSize());
    }
    
    
    static void printMethods(Class<?> c)
    {        
        Method[] methods = c.getDeclaredMethods(); // c.getMethods -> auch von Oberklassen
    
        for(Method method : methods)
        {
            System.out.println(method);
        }
    }
    
    static void printGetter(Class<?> c)
    {
        for(Method m: c.getDeclaredMethods())
        {            
            if(isGetter(m))
            {
                System.out.println(m.getName());
            }
        }
    }
    
    // gibt true zurück, wenn es sich um eine Getter-Methode handelt
    static boolean isGetter(Method m)
    {      
        return  m.getParameterCount() == 0
                
                &&
                
                (         m.getName().matches("^get.*")
                        && !m.getReturnType().equals(void.class)
                
                    ||
                
                    (       m.getName().matches("^(has|is).*")
                        &&  m.getReturnType().equals(boolean.class))
                    
                );
    }
   
    static void printSetter(Class<?> c)
    {
        for(Method m: c.getDeclaredMethods())
        {            
            if(isSetter(m))
            {
                System.out.println(m.getName());
            }
        }
    }
    
    static boolean isSetter(Method m)
    {      
        return      m.getName().matches("^(set).*")
                &&  m.getParameterCount() == 1
                &&  m.getReturnType().equals(void.class);    
    }    
    
    static void printParameter(Class<?> c)
    {        
        Method[] methods = c.getDeclaredMethods(); // c.getMethods -> auch von Oberklassen
    
        for(Method method : methods)
        {
            printParameter(method);
        }
    }
    
    static void printParameter(Method m)
    {        
        for(Parameter p: m.getParameters())
        {           
            System.out.println(p.getName());   
            System.out.println(p.getType().toString()); 
        }
    }
    
    /*
     * soll von der angegebenen Klasse alle Oberklassen-Namen mit 
     * syso ausgeben
     */
    static void printClassHierarchy(Class<?> c)
    {       
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        if(c != null)            
        {
            System.out.println(c.getSimpleName());
            printClassHierarchy(c.getSuperclass());
        }
    }
    
    static Object create(String className)
    {
        Object obj = null;
        try
        {
            Class<?> c = Class.forName(className);  // Class Loader
            obj = c.newInstance();                  
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
        return obj;
    }
}
