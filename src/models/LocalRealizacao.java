package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class LocalRealizacao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int codigo;
	private String local;
	
	@OneToMany(mappedBy="local", cascade= CascadeType.ALL)
	private List<Atividade> atividades;
	
	public LocalRealizacao() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
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
		return "LocalRealizacao [id=" + id + ", codigo=" + codigo + ", local="
				+ local + ", atividades=" + atividades + "]";
	}
	

}
