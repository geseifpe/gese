package br.com.gese.model;

import java.sql.Date;

import com.google.gson.annotations.SerializedName;

public class Projeto {
	
	@SerializedName("titulo")
	private String titulo;
	
	@SerializedName("data_inicio")
	private Date data_inicio;
	
	@SerializedName("data_fim")
	private Date data_fim;
	
	@SerializedName("ehfomento")
	private boolean ehfomento;
	
	@SerializedName("nota")
	private int nota;
	
	@SerializedName("status")
	private String status;
	
	@SerializedName("area_codigo")
	private String area_codigo;
	
	@SerializedName("qtd")
	private int qtd;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}

	public boolean isEhfomento() {
		return ehfomento;
	}

	public void setEhfomento(boolean ehfomento) {
		this.ehfomento = ehfomento;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getArea_codigo() {
		return area_codigo;
	}

	public void setArea_codigo(String area_codigo) {
		this.area_codigo = area_codigo;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
		
}
