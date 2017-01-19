package br.com.gese.model;

import com.google.gson.annotations.SerializedName;

public class Campus {
	
	@SerializedName("id")
	private int id;
	
	@SerializedName("campus")
	private String nome;
	
	@SerializedName("estado")
	private String estado;

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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
	
}
