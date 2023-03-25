package training.database.jdbc.with_gui.address.my_address_db.model;

public class Person
{
    private int id;
    private String vorname;
    private String nachname;
    private int plz;
    private String ort;
    private String strasse;
    private String telefon;
    private String mobil;
    private String email;
    
    
    public Person(int id, String vorname, String nachname,
                  int plz, String ort, String strasse, String telefon,
                  String mobil, String email)
    {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.plz = plz;
        this.ort = ort;
        this.strasse = strasse;
        this.telefon = telefon;
        this.mobil = mobil;
        this.email = email;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getVorname()
    {
        return this.vorname;
    }
    
    public void setVorname(String vorname)
    {
        this.vorname = vorname;
    }
    
    public String getNachname()
    {
        return this.nachname;
    }
    
    public void setNachname(String nachname)
    {
        this.nachname = nachname;
    }
    
    
    public int getPlz()
    {
        return this.plz;
    }
    
    
    public void setPlz(int plz)
    {
        this.plz = plz;
    }
    
    
    public String getOrt()
    {
        return this.ort;
    }
    
    public void setOrt(String ort)
    {
        this.ort = ort;
    }
    
    
    public String getStrasse()
    {
        return this.strasse;
    }
    
    public void setStrasse(String strasse)
    {
        this.strasse = strasse;
    }
    
    public String getTelefon()
    {
        return this.telefon;
    }
    
    public void setTelefon(String telefon)
    {
        this.telefon = telefon;
    }
    
    public String getMobil()
    {
        return this.mobil;
    }
    
    public void setMobil(String mobil)
    {
        this.mobil = mobil;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
}
