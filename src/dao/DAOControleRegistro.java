package dao;

import javax.persistence.Query;

import models.ControleRegistro;

public class DAOControleRegistro extends DAO<ControleRegistro> {
	public int getLast(){
		Query q = manager.createQuery("Select max(a.id) from ControleRegistro a");
		System.out.println(q.toString());
		return (Integer)q.getSingleResult();
	}
}
