package training.basics.hero;

import training.utilities.Calculations;

public enum Gender
{
    MALE("Herr", "us", "der", "Held", 179.9,14),
    FEMALE("Frau", "a", "die", "Heldin", 165.9,12.3);
    
    private final String
        title,
        nameSuffix,
        article,
        description;
    
    private final double
        avg,
        fullWidthAtHalfMaximum;
    
    Gender(String title, String nameSuffix, String article, String description, double avg, double fullWidthAtHalfMaximum)
    {
        this.title = title;
        this.nameSuffix = nameSuffix;
        this.article = article;
        this.description = description;
        this.avg = avg;
        this.fullWidthAtHalfMaximum = fullWidthAtHalfMaximum;
    }
    
    public static Gender getRandomGender(){
        return Calculations.tossUp() ? FEMALE : MALE;
    }
    
    public String getNameSuffix()
    {
        return nameSuffix;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public String getArticle()
    {
        return article;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public int randomHeight()
    {
        return Double.valueOf(Calculations.nextGaussian(avg, fullWidthAtHalfMaximum))
                     .intValue();
    }
}
