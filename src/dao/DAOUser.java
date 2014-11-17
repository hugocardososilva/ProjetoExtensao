package dao;

import javax.persistence.Query;

import models.Usuario;

public class DAOUser extends DAO<Usuario> {
	public Usuario login(String login, String senha) {
		Query q = manager.createQuery("SELECT U from Usuario U where U.login like :login and U.senha like :senha");
		q.setParameter("login", login);
		q.setParameter("senha", senha);

		if(q.getSingleResult()== null) return null;
		return (Usuario) q.getSingleResult();
	}

}
