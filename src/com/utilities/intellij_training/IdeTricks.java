package com.utilities.intellij_training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;


public class IdeTricks {



    private enum AnimalTypes {
        DOG,
        CAT,
        HORSE,
        COW,
        TIGER

    }









    private Integer value;


    static Logger logger = Logger.getAnonymousLogger();


    public Integer getValue() {


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> resultValues = new ArrayList<>();
        for (Integer value : numbers) {
            if (value % 2 == 1) {
                resultValues.add(value*2);
            }
        }
        System.out.println(resultValues);


        return value;
    }


    private static class MyStringSum
    {
        int a, b;
        
        MyStringSum(int a, int b){
            this.a = a;
            this.b = b;
        }
        
        @Override
        public String toString(){
            return a + " " + b;
        }
        
    }
    
    private static String someMethod(int a, int b) {
        return new MyStringSum(a,b).toString();
    }
    
    public static void main(String[] args)
    {
    
        Company company = new Company(null);
    
        for (Person person : company.getEmployee())
        {
            System.out.println(person.firstName);
    
            if ("John Doe".equals(person.firstName))
            {
                System.out.println(" Here is " + person.firstName);
            }
    
        }
    
        System.out.println(someMethod(1, 2));
        System.out.println(someMethod(3, 4));
    }
    

    
    
        /*
        Company company = new Company(null);
    
        for (Person person : company.getEmployee())
        {
            String fullName = person.lastName + person.getLastName();
        }
    
    
        for (Person myPerson : company.getEmployee())
        {
            System.out.println(myPerson);
        }
    
    
    
    
    
        final Pet pet = new Pet();

        */


}
