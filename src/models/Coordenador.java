package models;

import java.util.ArrayList;
import java.util.List;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Coordenador {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String nome;
	private String setor;
	private Long telPrimario;
	private Long telAuxiliar;
	private boolean voluntario;
	private String tipo;
	private String email;
	
	@OneToMany(mappedBy="coordenador", cascade= CascadeType.ALL)
	private List<Atividade> atividades = new ArrayList<Atividade>();

	public Coordenador() {
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

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelPrimario() {
		return telPrimario;
	}

	public void setTelPrimario(Long telPrimario) {
		this.telPrimario = telPrimario;
	}

	public Long getTelAuxiliar() {
		return telAuxiliar;
	}

	public void setTelAuxiliar(Long telAuxiliar) {
		this.telAuxiliar = telAuxiliar;
	}

	public boolean isVoluntario() {
		return voluntario;
	}

	public void setVoluntario(boolean voluntario) {
		this.voluntario = voluntario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
