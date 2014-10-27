package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@ManyToOne(cascade= CascadeType.PERSIST)
	private LocalRealizacao local;
	
	private String fonteDeRecurso;
	
	@ManyToOne(cascade= CascadeType.PERSIST)
	private AreaTematica areaTematica;
	
	@ManyToOne(cascade= CascadeType.PERSIST)
	private TipoAtividade tipoAtividade;
	
	@ManyToOne(cascade= CascadeType.PERSIST)
	private Vinculo vinculo;
	
	
	
	
	
	private String objetivo;
//	Relacionamentos
	@ManyToOne(cascade= CascadeType.PERSIST)
	private LinhaDeExtensao linhaDeExtensao;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Coordenador coordenador;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<Atividade> atividades ;
	
	@OneToOne(cascade= CascadeType.PERSIST)
	private AtividadeAntiga atividadeAntiga;
	
	@OneToMany(mappedBy= "atividade", cascade= CascadeType.ALL, fetch= FetchType.EAGER)
	private List<BeneficiarioDireto> beneficiariosDiretos;
	
	@OneToMany(mappedBy= "atividade", cascade= CascadeType.ALL, fetch=FetchType.EAGER)
	private List<BeneficiarioIndireto> beneficiariosIndiretos;
	
	@ManyToMany(cascade= CascadeType.ALL, fetch= FetchType.EAGER)
	private List<Docente> docentes;
	
	@ManyToMany(cascade= CascadeType.ALL, fetch= FetchType.EAGER)
	private List<Tecnico> tecnicos;
	
	@ManyToMany(cascade= CascadeType.ALL, fetch= FetchType.EAGER)
	private List<Bolsista> bolsistas;
	
	@ManyToMany(cascade= CascadeType.ALL, fetch= FetchType.EAGER)
	private List<Externos> externos;
	
	@OneToOne(cascade= CascadeType.ALL)
	private ControleRegistro controleRegistro;
	
	// construtor vazio(JPA)
	
	
	public Atividade() {
		super();
		this.atividades = new ArrayList<Atividade>();
		this.externos= new ArrayList<Externos>();
		this.bolsistas= new ArrayList<Bolsista>();
		this.tecnicos= new ArrayList<Tecnico>();
		this.docentes= new ArrayList<Docente>();
		this.beneficiariosDiretos= new ArrayList<BeneficiarioDireto>();
		this.beneficiariosIndiretos= new ArrayList<BeneficiarioIndireto>();
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
	

	public ControleRegistro getControleRegistro() {
		return controleRegistro;
	}

	public void setControleRegistro(ControleRegistro controleRegistro) {
		this.controleRegistro = controleRegistro;
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
	

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Date getDataInicio() {
//		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
//		return df2.format(dataInicio);
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
//		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
//		return df2.format(dataTermino);
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	

	public LocalRealizacao getLocal() {
		return local;
	}

	public void setLocal(LocalRealizacao local) {
		this.local = local;
	}

	public String getFonteDeRecurso() {
		return fonteDeRecurso;
	}

	public void setFonteDeRecurso(String fonteDeRecurso) {
		this.fonteDeRecurso = fonteDeRecurso;
	}

	public AreaTematica getAreaTematica() {
		return areaTematica;
	}

	public void setAreaTematica(AreaTematica areaTematica) {
		this.areaTematica = areaTematica;
	}

	public TipoAtividade getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(TipoAtividade tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

	public Vinculo getVinculo() {
		return vinculo;
	}

	public void setVinculo(Vinculo vinculo) {
		this.vinculo = vinculo;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
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

		public void addParticipante(ParticipanteInterface participante, String tipo){
			if(tipo.equalsIgnoreCase("docente")){
				this.docentes.add((Docente) participante);
			}else
				if(tipo.equalsIgnoreCase("bolsista")){
					this.bolsistas.add((Bolsista) participante);
				}else
					if(tipo.equalsIgnoreCase("externo")){
						this.externos.add((Externos) participante);
					}else
						if(tipo.equalsIgnoreCase("tecnico")){
							this.tecnicos.add((Tecnico)participante);
						}else
							if(tipo.equalsIgnoreCase("coordenador")){
								this.setCoordenador((Coordenador) participante);
							}
		
		}
		public void removeParticipante ( ParticipanteInterface participante, String tipo){
			if(tipo.equalsIgnoreCase("docente")){
				this.docentes.remove((Docente) participante);
			}else
				if(tipo.equalsIgnoreCase("bolsista")){
					this.bolsistas.remove((Bolsista) participante);
				}else
					if(tipo.equalsIgnoreCase("externo")){
						this.externos.remove((Externos) participante);
					}else
						if(tipo.equalsIgnoreCase("tecnico")){
							this.tecnicos.remove((Tecnico)participante);
						}
		}
		public void addAtividade(Atividade atividade){
			this.atividades.add(atividade);
		}
		public void removeAtividade(Atividade atividade){
			this.atividades.remove(atividade);
		}
		@Override
		public String toString() {
			return "Atividade [id=" + id + ", registro=" + registro
					+ ", titulo=" + titulo + ", valor=" + valor
					+ ", dataInicio=" + dataInicio + ", dataTermino="
					+ dataTermino + ", local=" + local + ", fonteDeRecurso="
					+ fonteDeRecurso + ", areaTematica=" + areaTematica
					+ ", tipoAtividade=" + tipoAtividade + ", vinculo="
					+ vinculo + ", objetivo=" + objetivo + ", linhaDeExtensao="
					+ linhaDeExtensao + ", coordenador=" + coordenador
					+ ", atividades=" + atividades + ", atividadeAntiga="
					+ atividadeAntiga + ", beneficiariosDiretos="
					+ beneficiariosDiretos + ", beneficiariosIndiretos="
					+ beneficiariosIndiretos + ", docentes=" + docentes
					+ ", tecnicos=" + tecnicos + ", bolsistas=" + bolsistas
					+ ", externos=" + externos + ", controleRegistro="
					+ controleRegistro + "]";
		}

		
		


		
		
}


