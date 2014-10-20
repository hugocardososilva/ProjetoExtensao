package dao;

import java.util.List;

import javax.persistence.Query;


import models.Participante;

public class DAOParticipante extends DAO<Participante> {
	@SuppressWarnings("unchecked")
	public List<Participante> findByNome(String nome){
		Query q= manager.createQuery("SELECT D from Participante D where D.nome like :nome");
		q.setParameter("nome",nome);
		return q.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Participante> findByEmail(String email){
		Query q= manager.createQuery("SELECT D from Participante D where D.email like :email");
			q.setParameter("email",email);
		return q.getResultList();
	}

}
