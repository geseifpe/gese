package br.com.gese.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import com.google.gson.annotations.SerializedName;

public class Aluno {

	@NotNull
	@CPF(message = "CPF inválido")
	@SerializedName("cpf")
	private String cpf;

	@NotNull
	@Size(max = 50)
	@SerializedName("nome")
	private String nome;

	@NotNull
	@Size(max = 20)
	@SerializedName("matricula")
	private String matricula;

	@NotNull
	@SerializedName("sexo")
	private char sexo;

	@SerializedName("nascimento")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate nascimento;

	@Size(max = 11)
	@SerializedName("campus_id")
	private int campus_id;

	@Size(max = 11)
	@SerializedName("curso_id")
	private int curso_id;

	@NotNull
	@Size(max = 20)
	@SerializedName("telefone")
	private String telefone;

	@Size(max = 20)
	@SerializedName("celular")
	private String celular;

	@NotNull
	@Size(max = 45)
	@Email
	@SerializedName("email")
	private String email;

	@NotNull
	@Size(max = 200)
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

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
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

	public int getCampus_id() {
		return campus_id;
	}

	public void setCampus_id(int campus_id) {
		this.campus_id = campus_id;
	}

	public int getCurso_id() {
		return curso_id;
	}

	public void setCurso_id(int curso_id) {
		this.curso_id = curso_id;
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

	public String getSexoCompleto() {
		if (this.sexo == 'M') {
			return "Masculino";
		} else {
			return "Feminino";
		}
	}
}
