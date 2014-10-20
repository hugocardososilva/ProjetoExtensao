package dao;

import javax.persistence.Query;

import models.Atividade;

public class DAOAtividade extends DAO<Atividade> {
	public int getLast(){
		Query q = manager.createQuery("Select max(a.id) from Atividade a");
		System.out.println(q.toString());
		return (Integer)q.getSingleResult();
	}

}
