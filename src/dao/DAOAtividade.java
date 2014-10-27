package dao;

import java.util.List;

import javax.persistence.Query;

import models.Atividade;

public class DAOAtividade extends DAO<Atividade> {
	public int getLast(){
		Query q = manager.createQuery("Select max(a.id) from Atividade a");
		System.out.println(q.toString());
		return (Integer)q.getSingleResult();
	}
	@SuppressWarnings("unchecked")
	public List<Atividade> findByTitulo(String titulo){
		String prepared= "%";
		prepared+= titulo;
		prepared+= "%";
		Query q= manager.createQuery("SELECT A from Atividade A where A.titulo like :titulo");
		q.setParameter("titulo",prepared);
		return q.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Atividade> findByRegistro(String registro){
		String prepared= "%";
		prepared+= registro;
		prepared+= "%";
		Query q= manager.createQuery("SELECT A from Atividade A where A.registro like :registro");
		q.setParameter("registro",prepared);
		return q.getResultList();
	}


}
