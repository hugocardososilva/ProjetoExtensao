package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class Participante {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String email;
	private boolean voluntario;
	
	
	
	public Participante() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isVoluntario() {
		return voluntario;
	}


	public void setVoluntario(boolean voluntario) {
		this.voluntario = voluntario;
	}




	


	@Override
	public String toString() {
		return "EquipeTematica [id=" + id + ", nome=" + nome + ", email="
				+ email + ", voluntario=" + voluntario + "]";
	}
	
	
	
}
