package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Bolsista extends Participante {
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Atividade> atividades;
	
	public Bolsista() {
		super();
		this.atividades= new ArrayList<Atividade>();
	}

	@Override
	public String toString() {
		return "Bolsista [getId()=" + getId() + ", getNome()=" + getNome()
				+ ", getEmail()=" + getEmail() + ", isVoluntario()="
				+ isVoluntario() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}
	public void addAtividade(Atividade atividade){
		this.atividades.add(atividade);
	}
	public void removeAtividade(Atividade atividade){
		this.atividades.remove(atividade);
	}

	
	
}
