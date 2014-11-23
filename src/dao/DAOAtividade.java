package dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import models.Atividade;

public class DAOAtividade extends DAO<Atividade> {
	DateFormat data= new SimpleDateFormat("yyyy-MM-dd");
	public int getLast(){
		Query q = manager.createQuery("Select max(a.id) from Atividade a ");
		System.out.println(q.toString());
		return (Integer)q.getSingleResult();
	}
	@SuppressWarnings("unchecked")
	public List<Atividade> findByTitulo(String titulo){
		String prepared= "%";
		prepared+= titulo;
		prepared+= "%";
		Query q= manager.createQuery("SELECT A from Atividade A where A.titulo like :titulo ORDER BY A.id");
		q.setParameter("titulo",prepared);
		return q.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Atividade> findByRegistro(String registro){
		String prepared= "%";
		prepared+= registro;
		prepared+= "%";
		Query q= manager.createQuery("SELECT A from Atividade A where A.registro like :registro ORDER BY A.id");
		q.setParameter("registro",prepared);
		return q.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Atividade> findByPeriodo(String inicio, String fim){
		
		try {
			Date dtInicio= data.parse(inicio);
			Date dtFim= data.parse(fim);
			Query q= manager.createQuery("SELECT A from Atividade A where A.dataInicio >= :dtInicio and A.dataInicio <= :dtFim ORDER BY A.id");
			q.setParameter("dtInicio", dtInicio);
			q.setParameter("dtFim", dtFim);
			return q.getResultList();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Atividade> findByTipo(int tipo){
		Query q= manager.createQuery("SELECT A from Atividade A JOIN A.tipoAtividade T where T.id = :tipo ORDER BY A.id");
		q.setParameter("tipo", tipo);
		return q.getResultList();
	}
	public List<Atividade> filtarPorPeriodo(String inicio, String fim, List<Atividade> atividades){
		try {
			
			Date dtInicio= data.parse(inicio);
			Date dtFim= data.parse(fim);
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<Atividade> findByVincunlo(String inicio, String fim, int vinculo){
		try {
			Date dtInicio= data.parse(inicio);
			Date dtFim= data.parse(fim);
			Query q= manager.createQuery("SELECT A from Atividade A JOIN A.vinculo V where V.id = :vinculo and "
					+ "A.dataInicio >= :dtInicio and A.dataInicio <= :dtFim ORDER BY A.id");
			q.setParameter("vinculo", vinculo);
			q.setParameter("dtInicio", dtInicio);
			q.setParameter("dtFim", dtFim);
			return q.getResultList();
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	@SuppressWarnings("unchecked")
	public List<Atividade> findByCoordenador(String inicio, String fim, int coordenador){
		try {
			Date dtInicio= data.parse(inicio);
			Date dtFim= data.parse(fim);
			Query q= manager.createQuery("SELECT A from Atividade A JOIN A.coordenador C where C.id = :coordenador and "
					+ "A.dataInicio >= :dtInicio and A.dataInicio <= :dtFim ORDER BY A.id");
			q.setParameter("coordenador", coordenador);
			q.setParameter("dtInicio", dtInicio);
			q.setParameter("dtFim", dtFim);
			return q.getResultList();
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}

}
