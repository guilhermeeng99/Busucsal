package br.ucsal.cliente.model;

public class Horario {

	private long id;
	private String data;
	private String roteiro;
	private String horario;

	public Horario() {
		
	}
	
	public Horario(long id, String data, String roteiro, String horario) {
		this.id = id;
		this.data = data;
		this.roteiro = roteiro;
		this.horario = horario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getRoteiro() {
		return roteiro;
	}

	public void setRoteiro(String roteiro) {
		this.roteiro = roteiro;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

}