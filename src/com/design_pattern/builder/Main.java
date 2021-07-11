package com.design_pattern.builder;

public class Main
{
    public static void main(String[] args)
    {
        Adresse adresse = new Adresse.Builder()
                                .strasse("Barmbeker Straße")
                                .hausnummer(187)
                                .plz(22299)
                                .stadt("Hamburg")
                                .build();
        
        System.out.println(adresse);
    }
}