package br.ucsal.roteiro.model;

public class Roteiro {

	private long id;
	private String rota;
	private String saida;
	private String parada;

	public Roteiro() {

	}

	public Roteiro(long id, String rota, String saida, String parada) {
		this.id = id;
		this.rota = rota;
		this.saida = saida;
		this.parada = parada;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRota() {
		return rota;
	}

	public void setRota(String rota) {
		this.rota = rota;
	}

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}

	public String getParada() {
		return parada;
	}

	public void setParada(String parada) {
		this.parada = parada;
	}

}