package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class LinhaDeExtensao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private int numero;
	private String denominacao;
	private String definicoes;
	
	
	@OneToMany(mappedBy="linhaDeExtensao", cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	private List<Atividade> atividades;
	
	public LinhaDeExtensao() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDenominacao() {
		return denominacao;
	}

	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}

	public String getDefinicoes() {
		return definicoes;
	}

	public void setDefinicoes(String definicoes) {
		this.definicoes = definicoes;
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
		return "LinhaDeExtensao [id=" + id + ", numero=" + numero
				+ ", denominacao=" + denominacao + ", definicoes=" + definicoes
				+  "]";
	}

	
	
}
