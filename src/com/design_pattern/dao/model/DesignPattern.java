package com.design_pattern.dao.model;

import java.io.Serializable;

public class DesignPattern implements Serializable, Cloneable
{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String beschreibung;
	
	public DesignPattern()
	{
	}
	
	public DesignPattern(String name, String beschreibung) {
		super();
		this.name = name;
		this.beschreibung = beschreibung;
	}

	public DesignPattern(int id, String name, String beschreibung) 
	{
		this.id = id;
		this.name = name;
		this.beschreibung = beschreibung;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	@Override
	public String toString() {
		return "DesignPattern [id=" + id + ", name=" + name + ", beschreibung=" + beschreibung + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DesignPattern other = (DesignPattern) obj;
		if (beschreibung == null) {
			if (other.beschreibung != null)
				return false;
		} else if (!beschreibung.equals(other.beschreibung))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beschreibung == null) ? 0 : beschreibung.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
}
