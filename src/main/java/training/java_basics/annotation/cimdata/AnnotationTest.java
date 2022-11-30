package training.java_basics.annotation.cimdata;

import java.lang.reflect.Method;

@ReleaseVersion("1.1.0")
class AnnotationTest
{
    public static void main(String[] args)
    {
        Method[] methods = AnnotationTest.class.getDeclaredMethods();
        
        for(Method method : methods)
        {
            CodeModified cm = method.getAnnotation(CodeModified.class);
            if(cm != null)
            {
                String methodName = method.getName();
                String autor = cm.autor();
                String data = cm.date();
                String bugfixes = cm.bugfixes();
                System.out.printf("%s: Autor=%s, Datum=%s, Bugfixes=%s%n", methodName, autor, data, bugfixes);
            }
        }
        
        //ReleaseVersion rv = AnnotationTest.class.getAnnotation(ReleaseVersion.class);
        //System.out.println("Release: " + rv.value());
    }
    
    
    @CodeModified(autor = "Jim", date = "11.02.2012", bugfixes = "Eceptionhandling")
    void m1()
    {
        
    }

    @CodeModified(autor = "Marta", date = "12.12.2013")
    void m2()
    {
        
    }
    
    @TestAnnotation(klasse = Integer.class, rv = @ReleaseVersion("1.0.1"), stringArray = { "a", "b" })
    void m3()
    {
        
    }
}
