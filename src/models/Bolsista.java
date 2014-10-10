package models;

import javax.persistence.Entity;

@Entity
public class Bolsista extends EquipeTematica {

	public Bolsista() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bolsista [getId()=" + getId() + ", getNome()=" + getNome()
				+ ", getEmail()=" + getEmail() + ", isVoluntario()="
				+ isVoluntario() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
	
	
}
