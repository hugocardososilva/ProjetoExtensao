package dao;

import java.util.List;

import javax.persistence.Query;

import models.Coordenador;
import models.Externos;

public class DAOCoordenador extends DAO<Coordenador> implements DAOParticipanteInterface<Coordenador>{
	@SuppressWarnings("unchecked")
	public List<Coordenador> findByNome(String nome){
		String prepared= "%";
		prepared+= nome;
		prepared+= "%";
		Query q= manager.createQuery("SELECT D from Coordenador D where D.nome like :nome");
		q.setParameter("nome",prepared);
		return q.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Coordenador> findByEmail(String email){
		String prepared= "%";
		prepared+= email;
		prepared+= "%";
		Query q= manager.createQuery("SELECT D from Coordenador D where D.email like :email");
			q.setParameter("email",prepared);
		return q.getResultList();
	}

}
