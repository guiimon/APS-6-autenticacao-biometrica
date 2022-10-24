package app.model;

import java.io.FileInputStream;

public class Usuario {
	//Parametros
	private int id;
	private String login;
	private FileInputStream biometria;
	private String nome;
	private String cargo;
	
	//Criadores
	public Usuario() {
		
	}
	
	public Usuario(int id,String login, String nome, String cargo) {
		setId(id);
		setLogin(login);
		setNome(nome);
		setCargo(cargo);
	}
	
	
	public Usuario(int id,String login,FileInputStream biometria, String nome, String cargo) {
		setId(id);
		setLogin(login);
		setBiometria(biometria);
		setNome(nome);
		setCargo(cargo);
	}
	
	public Usuario(String login,FileInputStream biometria, String nome, String cargo) {
		setLogin(login);
		setBiometria(biometria);
		setNome(nome);
		setCargo(cargo);
	}
	
	//Getters e Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public FileInputStream getBiometria() {
		return biometria;
	}
	public void setBiometria(FileInputStream biometria) {
		this.biometria = biometria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
	
}
