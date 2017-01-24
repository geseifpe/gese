package br.com.gese.model;

public class Usuario {
	
	private String cpf;
	private String perfil1;
	private String perfil2;
	private String perfil3;
	private String password;
	private String lastaccess;
	private String ativo;
	private String dataCadastro;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getPerfil1() {
		return perfil1;
	}
	public void setPerfil1(String perfil1) {
		this.perfil1 = perfil1;
	}
	public String getPerfil2() {
		return perfil2;
	}
	public void setPerfil2(String perfil2) {
		this.perfil2 = perfil2;
	}
	public String getPerfil3() {
		return perfil3;
	}
	public void setPerfil3(String perfil3) {
		this.perfil3 = perfil3;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getLastaccess() {
		return lastaccess;
	}
	public void setLastaccess(String lastaccess) {
		this.lastaccess = lastaccess;
	}
	
	
	

}
