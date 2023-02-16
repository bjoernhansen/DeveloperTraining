package training.utilities.xml.persistenz.standard;

import java.io.Serializable;

public class Adresse implements Serializable{
	
	private String[] ortbeispiele = {"Berlin","Hamburg","Dresden"};
	private String ort;

	public Adresse() {
		// TODO Auto-generated constructor stub
	}
	
	public Adresse(String ort) {
		super();
		this.ort = ort;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String[] getOrtbeispiele() {
		return ortbeispiele;
	}

	public void setOrtbeispiele(String[] ortbeispiele) {
		this.ortbeispiele = ortbeispiele;
	}

}
