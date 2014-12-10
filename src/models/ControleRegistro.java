package models;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import dao.DAO;
import dao.DAOAtividade;
import dao.DAOControleRegistro;

@Entity
public class ControleRegistro {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private int numero;
	@Temporal(TemporalType.DATE)
	private Date ano;
	@OneToOne(cascade=CascadeType.ALL)
	private Atividade atividade;
	
	
	
	public ControleRegistro() {
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


	public Date getAno() {
		return ano;
	}


	public void setAno(Date ano) {
		this.ano = ano;
	}


	public Atividade getAtividade() {
		return atividade;
	}


	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}


	@Override
	public String toString() {
		return "ControleRegistro [id=" + id + ", numero=" + numero + ", ano="
				+ ano + ", atividade=" + atividade.getId() + "]";
	}
	
	
	public static void EmitirControleDeRegistro(Atividade atividade){
		DateFormat data= new SimpleDateFormat("yy");
		DAOControleRegistro daocr= new DAOControleRegistro();
		DAOAtividade daoa= new DAOAtividade();
		DecimalFormat dLocal= new DecimalFormat("00");
		DecimalFormat dNumero= new DecimalFormat("000");
		DAO.open();
		DAO.begin();
		ControleRegistro ultimo =daocr.find(daocr.getLast());
		ControleRegistro cRegistro= new ControleRegistro();
		cRegistro.setAno(new Date(System.currentTimeMillis()));
		if(atividade.getControleRegistro()== null){
			if(ultimo == null){
				cRegistro.setNumero(1);
				System.out.println("nulo");
				
			}else{
				if(!data.format(ultimo.getAno()).equalsIgnoreCase(data.format(new Date(System.currentTimeMillis())))){
					cRegistro.setNumero(1);
					System.out.println("diferentes");
					System.out.println(data.format(ultimo.getAno()));
					System.out.println(data.format(new Date(System.currentTimeMillis())));
					
				}else{
					cRegistro.setNumero(ultimo.getNumero()+1);
					System.out.println("mesmo ano");
				}
			}
			cRegistro.setAtividade(atividade);
			atividade.setControleRegistro(cRegistro);
			
		}
		String numero= dNumero.format(atividade.getControleRegistro().getNumero());
		String tipo = atividade.getTipoAtividade().getSigla();
		String aTematica= atividade.getAreaTematica().getSigla();
		
		String local= dLocal.format(atividade.getLocal().getCodigo());
		
		String linha = dLocal.format(atividade.getLinhaDeExtensao().getNumero());
		String ano= data.format(atividade.getControleRegistro().getAno());
		
		String registro = tipo+"-"+aTematica+"-"+local+"-"+numero+"-"+linha+"-"+ano;
		System.out.println(registro);
		atividade.setRegistro(registro);
		daoa.merge(atividade);
		daocr.persist(cRegistro);
		
		DAO.commit();
		DAO.close();
	}
	
	

}
