package br.com.gese.model;

import com.google.gson.annotations.SerializedName;

public class Campus {
	
	@SerializedName("id")
	private int id;
	
	@SerializedName("cidade")
	private String cidade;
	
	@SerializedName("estado")
	private String estado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}	
}
