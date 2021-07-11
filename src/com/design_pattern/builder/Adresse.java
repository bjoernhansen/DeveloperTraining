package com.design_pattern.builder;

public class Adresse
{
    private final String strasse;
    private final int hausnummer;
    private final int plz;
    private final String stadt;    
    
    private Adresse(Builder builder)
    {
        this.strasse = builder.strasse;
        this.hausnummer = builder.hausnummer;
        this.plz = builder.plz;
        this.stadt = builder.stadt;
    }
        
    static class Builder
    {
        String strasse;
        int hausnummer;
        int plz;
        String stadt;
        
        @SuppressWarnings("hiding")
        Builder strasse(String strasse)
        {
            this.strasse = strasse;
            return this;
        }
        
        @SuppressWarnings("hiding")
        Builder hausnummer( int hausnummer)
        {
            this.hausnummer = hausnummer;
            return this;
        }
        
        @SuppressWarnings("hiding")
        Builder plz(int plz)
        {
            this.plz = plz;
            return this;
        }
        
        @SuppressWarnings("hiding")
        Builder stadt(String stadt)
        {
            this.stadt = stadt;
            return this;
        }  
        
        public Adresse build()
        {
            return new Adresse(this); 
        }
    }
    
    @Override
    public String toString(){
        return "Adresse:\n" + strasse + " " + hausnummer + "\n" + plz + " " + stadt;
    }
}
