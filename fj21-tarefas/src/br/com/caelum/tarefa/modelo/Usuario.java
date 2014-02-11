package br.com.caelum.tarefa.modelo;

import javax.persistence.Entity;;

public class Usuario {
	private String login;
	private String senha;

	public String getlogin() {
		return login;
	}
	public void setlogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
