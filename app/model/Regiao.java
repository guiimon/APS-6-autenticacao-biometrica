package app.model;

public class Regiao {
	//Parametros
	private int id;
	private String identificacao;
	private String impacto;
	private int ocorrencias;
	
	//Criadores
	public Regiao() {
		
	}
	
	public Regiao(int id, String identificacao, String impacto, int ocorrencias) {
		setId(id);
		setIdentificacao(identificacao);
		setImpacto(impacto);
		setOcorrencias(ocorrencias);
	}
	
	public Regiao(String identificacao, String impacto, int ocorrencias) {
		setIdentificacao(identificacao);
		setImpacto(impacto);
		setOcorrencias(ocorrencias);
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
	public String getImpacto() {
		return impacto;
	}
	public void setImpacto(String impacto) {
		this.impacto = impacto;
	}
	public int getOcorrencias() {
		return ocorrencias;
	}
	public void setOcorrencias(int ocorrencias) {
		this.ocorrencias = ocorrencias;
	}
	
	
	
}
