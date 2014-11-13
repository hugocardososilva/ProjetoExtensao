package models;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;

	private String login;
	private String nome;
	private String senha;
	private String email;
	private Long telefone;
	private String privilegio;
	
	@OneToMany(mappedBy= "usuario", cascade=CascadeType.PERSIST)
	private List<Atividade> atividades;

	public Usuario() {
		
		this.atividades= new ArrayList<Atividade>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha){
		this.senha= senha;
			try {
				this.senha = this.convertPasswordToMD5(senha);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public String getPrivilegio() {
		return privilegio;
	}

	public void setPrivilegio(String privilegio) {
		this.privilegio = privilegio;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}
	public void addAtividade(Atividade atividade){
		this.atividades.add(atividade);
	}
	public void removeAtividade(Atividade atividade){
		this.atividades.remove(atividade);
	}
	 public static String convertPasswordToMD5(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	 
	        BigInteger hash = new BigInteger(1, md.digest(password.getBytes("UTF-8")));
	 
	        return String.format("%32x", hash);
	    }
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", senha=" + senha
				+ ", email=" + email + ", telefone=" + telefone
				+ ", privilegio=" + privilegio + "]";
	}
	
	

}
