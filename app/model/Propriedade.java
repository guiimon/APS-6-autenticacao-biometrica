package app.model;

public class Propriedade {
	//Parametros
	private int id;
	private String cep;
	private String estado;
	private int numero;
	private int regiao;
	
	//Criadores
	public Propriedade() {
		
	}
	
	public Propriedade(int id, String cep, String estado, int numero, int regiao) {
		setId(id);
		setCep(cep);
		setEstado(estado);
		setNumero(numero);
		setRegiao(regiao);
	}
	
	public Propriedade(String cep, String estado, int numero, int regiao) {
		setCep(cep);
		setEstado(estado);
		setNumero(numero);
		setRegiao(regiao);
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getRegiao() {
		return regiao;
	}
	public void setRegiao(int regiao) {
		this.regiao = regiao;
	}
	
	
	
	
	
}
