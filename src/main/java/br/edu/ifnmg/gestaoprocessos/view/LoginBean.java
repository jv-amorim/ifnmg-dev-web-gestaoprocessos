package br.edu.ifnmg.gestaoprocessos.view;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

//Classe feita apenas para testar o front da tela de login.

@Named
@ViewScoped
public class LoginBean implements Serializable{
	
	private String usuario;
	private String senha;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}

