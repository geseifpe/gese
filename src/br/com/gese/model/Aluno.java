package br.com.gese.model;

import com.google.gson.annotations.SerializedName;

public class Aluno {
	@SerializedName("cpf")
	private String cpf;
	
	@SerializedName("nome")
	private String nome;
	
	@SerializedName("matricula")
	private String matricula;
	
	@SerializedName("cursoId")
	private int cursoId;
	
	@SerializedName("sexo")
	private char sexo;
	
	@SerializedName("nascimento")
	private String nascimento;
	
	@SerializedName("campusId")
	private int campusId;
	
	@SerializedName("telefone")
	private String telefone;
	
	@SerializedName("celular")
	private String celular;
	
	@SerializedName("email")
	private String email;
	
	@SerializedName("linklattes")
	private String linklattes;
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public char getSexo() {
		return sexo;
	}

	public void setsexo(char sexo) {
		this.sexo = sexo;
	}
	
	public String getNascimento() {
		return nascimento;
	}

	public void setNascmimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public int getCursoId() {
		return cursoId;
	}

	public void setCursoId(int cursoId) {
		this.cursoId = cursoId;
	}

	public int getCampusId() {
		return campusId;
	}

	public void setCampusId(int campusId) {
		this.campusId = campusId;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public String getLinklattes() {
		return linklattes;
	}

	public void setLinklattes(String linklattes) {
		this.linklattes = linklattes;
	}

	

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	
}
