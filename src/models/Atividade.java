package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.jpa.config.Cascade;


@Entity
public class Atividade {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String registro;
	private String titulo;
	private Double valor;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	private Date dataTermino;
	
	private String local;
	private String fonteDeRecurso;
	private String areaTematica;
	
	@OneToMany(cascade= CascadeType.MERGE)
	private LinhaDeExtensao linhaProgramatica;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	private Coordenador coordenador;
	
	private String tipoAtividade;
	private String vinculo;
	
	@OneToOne(cascade= CascadeType.ALL)
	private AtividadeAntiga atividadeAntiga;
	
	@OneToMany(mappedBy= "atividade", cascade= CascadeType.ALL)
	private List<BeneficiarioDireto> beneficiariosDiretos;
	
	@OneToMany(mappedBy= "atividade", cascade= CascadeType.ALL)
	private List<BeneficiarioIndireto> beneficiariosIndiretos;
	
	@OneToMany(mappedBy= "atividade", cascade= CascadeType.ALL)
	private List<Docente> docentes;
	
	@OneToMany(mappedBy= "atividade", cascade= CascadeType.ALL)
	private List<Tecnico> tecnicos;
	
	@OneToMany(mappedBy= "atividade", cascade= CascadeType.ALL)
	private List<Bolsista> bolsistas;
	
	@OneToMany(mappedBy= "atividade", cascade= CascadeType.ALL)
	private List<Externos> externos;
}
