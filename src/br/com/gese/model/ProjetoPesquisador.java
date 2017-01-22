package br.com.gese.model;

import java.sql.Date;

import com.google.gson.annotations.SerializedName;

public class ProjetoPesquisador {
	
	@SerializedName("pesquisador_siape")
	private String pesquisador_siape;
	
	@SerializedName("projeto_id")
	private int projeto_id;
	
	@SerializedName("ehcoordenador")
	private String ehcoordenador;
	
	@SerializedName("data_inscriçao")
	private Date data_inscriçao;
	
	@SerializedName("ativo")
	private boolean ativo;
	
	@SerializedName("data_saida")
	private Date data_saida;
	
	public String getPesquisador_siape() {
		return pesquisador_siape;
	}

	public void setPesquisador_siape(String pesquisador_siape) {
		this.pesquisador_siape = pesquisador_siape;
	}

	public int getProjeto_id() {
		return projeto_id;
	}

	public void setProjeto_id(int projeto_id) {
		this.projeto_id = projeto_id;
	}

	public String getEhcoordenador() {
		return ehcoordenador;
	}

	public void setEhcoordenador(String ehcoordenador) {
		this.ehcoordenador = ehcoordenador;
	}

	public Date getData_inscriçao() {
		return data_inscriçao;
	}

	public void setData_inscriçao(Date data_inscriçao) {
		this.data_inscriçao = data_inscriçao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Date getData_saida() {
		return data_saida;
	}

	public void setData_saida(Date data_saida) {
		this.data_saida = data_saida;
	}	
}
