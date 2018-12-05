package br.ucsal.busucsal.model;

public class Horario {

	private long id;
	private String horario;
	private String data;
	private String roteiro;

	public Horario() {

	}

	public Horario(long id, String horario, String data, String roteiro) {
		super();
		this.id = id;
		this.horario = horario;
		this.data = data;
		this.roteiro = roteiro;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
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

}