package training.database.jdbc.with_gui.simple;


public class DesignPattern
{
	private int id;
	
	private String name;
	
	private String beschreibung;
	
	
	
	public DesignPattern(int id, String name, String beschreibung)
	{
		this.id = id;
		this.name = name;
		this.beschreibung = beschreibung;
	}
		
	public String getVorname() {
		return this.name;
	}
	public void setVorame(String name) {
		this.name = name;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNachname() {
		return this.beschreibung;
	}
	public void setNachname(String nachname) {
		this.beschreibung = nachname;
	}
}
