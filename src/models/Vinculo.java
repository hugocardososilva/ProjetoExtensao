package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Vinculo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	
	@OneToMany(mappedBy="vinculo", cascade= CascadeType.ALL)
	private List<Atividade> atividades;

	public Vinculo() {
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

	@Override
	public String toString() {
		return "Vinculo [id=" + id + ", nome=" + nome + ", atividades="
				+ atividades + "]";
	}
	
}
