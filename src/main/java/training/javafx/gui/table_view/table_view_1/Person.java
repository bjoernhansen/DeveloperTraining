package training.javafx.gui.table_view.table_view_1;

import java.time.LocalDate;

public class Person {
	private String vorname;
	private String nachname;
	private LocalDate geburtsdatum;
	private int id;
	
	
	public Person() {
	}
	public Person(String name, int id) {
		this.vorname = name;
		this.id = id;
	}
	
	
	public Person(String vorname, String nachname, LocalDate geburtsdatum, int id) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsdatum = geburtsdatum;
		this.id = id;
	}


	public String getVorname() {
		return this.vorname;
	}
	public void setVorame(String name) {
		this.vorname = name;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNachname() {
		return this.nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public LocalDate getGeburtsdatum() {
		return this.geburtsdatum;
	}
	public void setGeburtsdatum(LocalDate geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	
	

}
