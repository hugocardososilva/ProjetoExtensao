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
	private String tipoAtividade;
	private String vinculo;
	
//	Relacionamentos
	@ManyToOne(cascade= CascadeType.MERGE)
	private LinhaDeExtensao linhaDeExtensao;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	private Coordenador coordenador;
	
	
	
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
	
	
	// construtor vazio(JPA)
	
	
	public Atividade() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getFonteDeRecurso() {
		return fonteDeRecurso;
	}

	public void setFonteDeRecurso(String fonteDeRecurso) {
		this.fonteDeRecurso = fonteDeRecurso;
	}

	public String getAreaTematica() {
		return areaTematica;
	}

	public void setAreaTematica(String areaTematica) {
		this.areaTematica = areaTematica;
	}

	public String getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(String tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

	public String getVinculo() {
		return vinculo;
	}

	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}

	public LinhaDeExtensao getLinhaDeExtensao() {
		return linhaDeExtensao;
	}

	public void setLinhaDeExtensao(LinhaDeExtensao linhaDeExtensao) {
		this.linhaDeExtensao = linhaDeExtensao;
	}

	public Coordenador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}

	public AtividadeAntiga getAtividadeAntiga() {
		return atividadeAntiga;
	}

	public void setAtividadeAntiga(AtividadeAntiga atividadeAntiga) {
		this.atividadeAntiga = atividadeAntiga;
	}

	public List<BeneficiarioDireto> getBeneficiariosDiretos() {
		return beneficiariosDiretos;
	}

	public void setBeneficiariosDiretos(
			List<BeneficiarioDireto> beneficiariosDiretos) {
		this.beneficiariosDiretos = beneficiariosDiretos;
	}

	public List<BeneficiarioIndireto> getBeneficiariosIndiretos() {
		return beneficiariosIndiretos;
	}

	public void setBeneficiariosIndiretos(
			List<BeneficiarioIndireto> beneficiariosIndiretos) {
		this.beneficiariosIndiretos = beneficiariosIndiretos;
	}

	public List<Docente> getDocentes() {
		return docentes;
	}

	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}

	public List<Tecnico> getTecnicos() {
		return tecnicos;
	}

	public void setTecnicos(List<Tecnico> tecnicos) {
		this.tecnicos = tecnicos;
	}

	public List<Bolsista> getBolsistas() {
		return bolsistas;
	}

	public void setBolsistas(List<Bolsista> bolsistas) {
		this.bolsistas = bolsistas;
	}

	public List<Externos> getExternos() {
		return externos;
	}

	public void setExternos(List<Externos> externos) {
		this.externos = externos;
	}
	
		//serviços de adicionar e remover no ArrayList
		
		//equipe tematica
		
		public void addExternos(Externos externos){
			this.externos.add(externos);
		}
		public void removeExternos(Externos externos){
			this.externos.remove(externos);
		}
		public void addDocente(Docente docente){
			this.docentes.add(docente);
		}
		public void removeDocente(Docente docente){
			this.docentes.remove(docente);
		}
		public void addTecnico(Tecnico tecnico){
			this.tecnicos.add(tecnico);
		}
		public void removeTecnico(Tecnico tecnico){
			this.tecnicos.remove(tecnico);
		}
		public void addBolsista(Bolsista bolsista){
			this.bolsistas.add(bolsista);
		}
		public void removeBolsista(Bolsista bolsista){
			this.bolsistas.remove(bolsista);
		}
		
//		adicionando e removendo beneficiarios
		public void addBeneficiarioDireto(BeneficiarioDireto direto){
			this.beneficiariosDiretos.add(direto);
		}
		public void removeBeneficiarioDireto(BeneficiarioDireto direto){
			this.beneficiariosDiretos.remove(direto);
		}
		public void addBeneficiarioIndireto(BeneficiarioIndireto indireto){
			this.beneficiariosIndiretos.add(indireto);
		}
		public void removeBeneficiarioIndireto(BeneficiarioIndireto indireto){
			this.beneficiariosIndiretos.remove(indireto);
		}
}


