package br.ucsal.cliente.model;

public class Rota {

	private long id;
	private String roteiro;
	private String saida;
	private String paradas;

	public Rota() {

	}

	public Rota(long id, String roteiro, String saida, String paradas) {
		this.id = id;
		this.roteiro = roteiro;
		this.saida = saida;
		this.paradas = paradas;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoteiro() {
		return roteiro;
	}

	public void setRoteiro(String roteiro) {
		this.roteiro = roteiro;
	}

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}

	public String getParadas() {
		return paradas;
	}

	public void setParadas(String paradas) {
		this.paradas = paradas;
	}

}