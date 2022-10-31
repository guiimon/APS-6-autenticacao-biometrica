package app.model;

import java.io.FileInputStream;

public class Usuario {
	//Parametros
	private int id;
	private String login;
	private String biometria;
	private FileInputStream input;
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
	
	
	public Usuario(int id,String login,String biometria, String nome, String cargo) {
		setId(id);
		setLogin(login);
		setBiometria(biometria);
		setNome(nome);
		setCargo(cargo);
	}
	
	public Usuario(int id, String login,FileInputStream biometria, String nome, String cargo) {
		setId(id);
		setLogin(login);
		setInput(biometria);
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
	
	
	public FileInputStream getInput() {
		return input;
	}
	public void setInput(FileInputStream biometria) {
		this.input = biometria;
	}
	
	public String getBiometria() {
		return biometria;
	}

	public void setBiometria(String biometria) {
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
