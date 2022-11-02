package app.model;

public class Responsavel {
	//Parametros
	private int id;
	private String nome;
	private String cpf;
	private int idade;
	private String dataNasc;
	private int propriedade;
	
	public Responsavel(int id, String nome, String cpf, int idade, String dataNasc, int propriedade) {
		setId(id);
		setNome(nome);
		setCpf(cpf);
		setIdade(idade);
		setDataNasc(dataNasc);
		setPropriedade(propriedade);
	}
	
	public Responsavel(String nome, String cpf,int idade, String dataNasc, int propriedade) {
		setNome(nome);
		setCpf(cpf);
		setIdade(idade);
		setDataNasc(dataNasc);
		setPropriedade(propriedade);
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	public Responsavel() {
		
	}
	
	public int getPropriedade() {
		return propriedade;
	}
	public void setPropriedade(int propriedade) {
		this.propriedade = propriedade;
	}
	
	
	
}
