package com.utilities.intellij_training;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static java.lang.System.currentTimeMillis;







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


    private void someMethod() {

        if (value == null) {

        }
    }




    public static void main(String[] args) {







        currentTimeMillis();


        Company company = new Company(null);

        for (Person person : company.getEmployee()) {
            String fullName = person.firstName + " " + person.firstName;
        }


        for (Person person : company.getEmployee()) {
            System.out.println(person.firstName);
        }







        final Pet pet = new Pet();




    }





}
