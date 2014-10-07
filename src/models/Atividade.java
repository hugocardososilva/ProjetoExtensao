package models;

import java.util.Date;
import java.util.List;



public class Atividade {
	private int id;
	private String registro;
	private String titulo;
	private Double valor;
	private Date dataInicio;
	private Date dataTermino;
	private LocalRealizacao local;
	private FonteDeRecurso fonteDeRecurso;
	private AreaTematica areaTematica;
	private LinhaProgramatica linhaProgramatica;
	private Coordenador coordenador;
	private TIpoAtividade tipoAtividade;
	private List<Vinculo> vinculos;
	private AtividadeAntiga atividadeAntiga;
	private List<BeneficiarioDireto> beneficiariosDiretos;
	private List<BeneficiarioIndireto> beneficiariosIndiretos;
	private List<Docente> docentes;
	private List<Tecnico> tecnicos;
	private List<Bolsista> bolsistas;
	private List<Externos> externos;
}
