package br.com.gese.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;
import com.google.gson.annotations.SerializedName;

public class Pesquisador {
	
	@NotNull
	@Size(max = 45)
	@SerializedName("siape")
	private String siape;
	
	@NotNull
	@CPF
	@SerializedName("cpf")
	private String cpf;
	
	@NotNull
	@Size(max = 50)
	@SerializedName("nome")
	private String nome;
		
	@Size(max = 1)
	@SerializedName("cargo")
	private char cargo;
	
	@NotNull
	@Size(max = 1)
	@SerializedName("titulacao")
	private char titulacao;
	
	@NotNull
	@Size(max = 1)
	@SerializedName("sexo")
	private char sexo;
	
	@NotNull
	@Size(max = 2)
	@SerializedName("regime")
	private String regime;
	
	@NotNull
	@Size(max = 11)
	@SerializedName("campus_id")
	private int campus_id;
		
	@Size(max = 11)
	@SerializedName("departamento_id")
	private int departamento_id;
		
	@Size(max = 20)
	@SerializedName("telefone")
	private String telefone;
	
	@NotNull
	@Size(max = 20)
	@SerializedName("celular")
	private String celular;
	
	@NotNull
	@Email
	@SerializedName("email1")
	private String email1;
	
	@Email
	@SerializedName("email2")
	private String email2;
	
	@NotNull
	@Size(max = 200)
	@SerializedName("linklattes")
	private String linklattes;
	
	@Size(max = 200)
	@SerializedName("area_codigo")
	private String area_codigo;
	
	public String getSiape() {
		return siape;
	}
	
	public void setSiape(String siape) {
		this.siape = siape;
	}
	
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
	
	public char getCargo() {
		return cargo;
	}
	
	public void setCargo(char cargo) {
		this.cargo = cargo;		
	}
	
	public char getTitulacao() {
		return titulacao;
	}
	
	public void setTitulacao(char titulacao) {
		this.titulacao = titulacao;		
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public String getSexoCompleto(){
		if(this.sexo == 'M'){
			return "Masculino";
		}else{
			return "Feminino";
		}
	}
	
	public String getTitulacaoCompleta(){
		if(this.titulacao == 'M'){
			return "Mestrado";
		}else{
			return "Doutorado";
		}
	}
	
	public String getRegime() {
		return regime;
	}
	
	public void setRegime(String regime) {
		this.regime = regime;
	}
	
	
	public int getCampus_id() {
		return campus_id;
	}

	public void setCampus_id(int campus_id) {
		this.campus_id = campus_id;
	}

	public int getDepartamento_id() {
		return departamento_id;
	}
	
	public void setDepartamento_id(int departamento_id) {
		this.departamento_id = departamento_id;		
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
	
	public String getEmail1() {
		return email1;
	}
	
	public void setEmail1(String email1) {
		this.email1 = email1;		
	}
	
	public String getEmail2() {
		return email2;
	}
	
	public void setEmail2(String email2) {
		this.email2 = email2;		
	}

	
	public String getLinklattes() {
		return linklattes;
	}

	public void setLinklattes(String linklattes) {
		this.linklattes = linklattes;
	}

	public String getArea_codigo() {
		return area_codigo;
	}

	public void setArea_codigo(String area_codigo) {
		this.area_codigo = area_codigo;
	}
}

