package training.utilities.xml.persistenz.standard;

import java.io.Serializable;

public class Person implements Serializable{
	
	private String name;
	private Adresse adresse;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, Adresse adresse) {
		super();
		this.name = name;
		this.adresse = adresse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	

}
